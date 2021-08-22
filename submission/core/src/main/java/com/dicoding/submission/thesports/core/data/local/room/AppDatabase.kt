package com.dicoding.submission.thesports.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.submission.thesports.core.data.local.entity.EventEntity
import com.dicoding.submission.thesports.core.data.local.room.dao.EventDao

@Database(entities = [EventEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun eventDao(): EventDao
}