package com.dicoding.submission.thesports.di

import com.dicoding.submission.thesports.core.domain.useCase.EventUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun eventUseCase(): EventUseCase
}