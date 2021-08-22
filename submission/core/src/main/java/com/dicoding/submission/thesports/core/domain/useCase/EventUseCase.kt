package com.dicoding.submission.thesports.core.domain.useCase

import com.dicoding.submission.thesports.core.data.commons.Resource
import com.dicoding.submission.thesports.core.domain.model.EventDomainModel
import kotlinx.coroutines.flow.Flow

interface EventUseCase {
    fun getAllEvent(): Flow<Resource<List<EventDomainModel>>>
    fun getFavoriteEvent(): Flow<List<EventDomainModel>>
    suspend fun setFavoriteEvent(event: EventDomainModel, state: Boolean)
}