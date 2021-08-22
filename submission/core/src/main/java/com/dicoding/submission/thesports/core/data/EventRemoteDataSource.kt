package com.dicoding.submission.thesports.core.data

import com.dicoding.submission.thesports.core.data.remote.network.ApiResponse
import com.dicoding.submission.thesports.core.data.remote.network.ApiService
import com.dicoding.submission.thesports.core.data.remote.response.EventsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getListEvent(): Flow<ApiResponse<List<EventsItem>>>{
        return flow {
            try {
                val response = apiService.getListEvent()
                val list = response.events
                if (list.isNotEmpty()){
                    emit(ApiResponse.Success(list))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}