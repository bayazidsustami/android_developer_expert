package com.dicoding.submission.thesports.core.di

import android.content.Context
import androidx.room.Room
import com.dicoding.submission.thesports.core.data.local.room.AppDatabase
import com.dicoding.submission.thesports.core.data.local.room.dao.EventDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "sports.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideEventDao(database: AppDatabase): EventDao{
        return database.eventDao()
    }
}