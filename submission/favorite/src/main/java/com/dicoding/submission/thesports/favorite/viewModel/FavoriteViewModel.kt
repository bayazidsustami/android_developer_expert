package com.dicoding.submission.thesports.favorite.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.submission.thesports.core.domain.useCase.EventUseCase

class FavoriteViewModel(
    useCase: EventUseCase
): ViewModel() {
    val listFavoriteUseCase = useCase.getFavoriteEvent().asLiveData()
}