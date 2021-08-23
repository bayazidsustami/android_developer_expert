package com.dicoding.submission.thesports.core.domain.useCase

import com.dicoding.submission.thesports.core.data.commons.Resource
import com.dicoding.submission.thesports.core.domain.model.EventDomainModel
import com.dicoding.submission.thesports.core.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventUseCaseImpl @Inject constructor(
    private val repository: EventRepository
): EventUseCase {
    override fun getAllEvent(): Flow<Resource<List<EventDomainModel>>> =
        repository.getListEvent()

    override fun getFavoriteEvent(): Flow<List<EventDomainModel>> =
        repository.getFavoriteEvent()

    override suspend fun setFavoriteEvent(event: EventDomainModel, state: Boolean) =
        repository.setFavoriteEvent(event, state)
}