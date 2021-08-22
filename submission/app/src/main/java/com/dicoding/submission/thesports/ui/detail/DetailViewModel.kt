package com.dicoding.submission.thesports.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.submission.thesports.core.domain.model.EventDomainModel
import com.dicoding.submission.thesports.core.domain.useCase.EventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: EventUseCase
): ViewModel() {

    fun setFavorite(event: EventDomainModel, state: Boolean){
        viewModelScope.launch {
            useCase.setFavoriteEvent(event, state)
        }
    }
}