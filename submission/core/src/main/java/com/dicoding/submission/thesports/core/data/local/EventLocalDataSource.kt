package com.dicoding.submission.thesports.core.data.local

import com.dicoding.submission.thesports.core.data.local.entity.EventEntity
import com.dicoding.submission.thesports.core.data.local.room.dao.EventDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventLocalDataSource @Inject constructor(private val eventDao: EventDao) {
    fun getAllEvent(): Flow<List<EventEntity>> = eventDao.getAllEvent()

    fun getFavoriteEvent(): Flow<List<EventEntity>> = eventDao.getFavoriteEvent()

    suspend fun insertAllEvent(event: List<EventEntity>) = eventDao.insertAllEvent(event)

    suspend fun setFavoriteEvent(event: EventEntity, newState: Boolean){
        event.isFavorite = newState
        eventDao.updateFavoriteEvent(event)
    }
}