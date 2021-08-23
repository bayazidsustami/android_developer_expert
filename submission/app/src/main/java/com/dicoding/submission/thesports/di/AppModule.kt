package com.dicoding.submission.thesports.di

import com.dicoding.submission.thesports.core.domain.useCase.EventUseCase
import com.dicoding.submission.thesports.core.domain.useCase.EventUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun provideEventUseCase(useCase: EventUseCaseImpl): EventUseCase
}