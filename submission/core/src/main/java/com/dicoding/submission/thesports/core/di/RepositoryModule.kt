package com.dicoding.submission.thesports.core.di

import com.dicoding.submission.thesports.core.data.repository.EventRepositoryImpl
import com.dicoding.submission.thesports.core.domain.repository.EventRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repository: EventRepositoryImpl): EventRepository
}