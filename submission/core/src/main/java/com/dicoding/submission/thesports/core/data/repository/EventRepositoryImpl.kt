package com.dicoding.submission.thesports.core.data.repository

import com.dicoding.submission.thesports.core.data.commons.NetworkBoundResource
import com.dicoding.submission.thesports.core.data.commons.Resource
import com.dicoding.submission.thesports.core.data.local.EventLocalDataSource
import com.dicoding.submission.thesports.core.data.remote.EventRemoteDataSource
import com.dicoding.submission.thesports.core.data.remote.network.ApiResponse
import com.dicoding.submission.thesports.core.data.remote.response.EventsItem
import com.dicoding.submission.thesports.core.domain.model.EventDomainModel
import com.dicoding.submission.thesports.core.domain.repository.EventRepository
import com.dicoding.submission.thesports.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepositoryImpl @Inject constructor(
    private val localDataSource: EventLocalDataSource,
    private val remoteDataSource: EventRemoteDataSource
): EventRepository {

    override fun getListEvent(): Flow<Resource<List<EventDomainModel>>> {
        return object : NetworkBoundResource<List<EventDomainModel>, List<EventsItem>>(){
            override fun loadFromDb(): Flow<List<EventDomainModel>> {
                return localDataSource.getAllEvent().map {
                    DataMapper.mapEventEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<EventDomainModel>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<EventsItem>>> {
                return remoteDataSource.getListEvent()
            }

            override suspend fun saveCallResult(data: List<EventsItem>) {
                val eventList = DataMapper.mapEventResponsesToEntities(data)
                localDataSource.insertAllEvent(eventList)
            }
        }.asFlow()
    }

    override fun getFavoriteEvent(): Flow<List<EventDomainModel>> {
        return localDataSource.getFavoriteEvent().map {
            DataMapper.mapEventEntitiesToDomain(it)
        }
    }

    override suspend fun setFavoriteEvent(event: EventDomainModel, state: Boolean) {
        localDataSource.setFavoriteEvent(DataMapper.mapEventDomainToEntity(event), state)
    }

}