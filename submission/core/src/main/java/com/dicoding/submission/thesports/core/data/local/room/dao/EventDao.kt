package com.dicoding.submission.thesports.core.data.local.room.dao

import androidx.room.*
import com.dicoding.submission.thesports.core.data.local.entity.EventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEvent(list: List<EventEntity>)

    @Query("SELECT * FROM event_entity")
    fun getAllEvent(): Flow<List<EventEntity>>

    @Query("SELECT * FROM event_entity WHERE is_favorite = 1")
    fun getFavoriteEvent(): Flow<List<EventEntity>>

    @Update
    suspend fun updateFavoriteEvent(event: EventEntity)
}