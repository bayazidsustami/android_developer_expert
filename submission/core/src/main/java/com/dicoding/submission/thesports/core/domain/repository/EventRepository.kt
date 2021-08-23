package com.dicoding.submission.thesports.core.domain.repository

import com.dicoding.submission.thesports.core.data.commons.Resource
import com.dicoding.submission.thesports.core.domain.model.EventDomainModel
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    fun getListEvent(): Flow<Resource<List<EventDomainModel>>>
    fun getFavoriteEvent(): Flow<List<EventDomainModel>>
    suspend fun setFavoriteEvent(event: EventDomainModel, state: Boolean)
}