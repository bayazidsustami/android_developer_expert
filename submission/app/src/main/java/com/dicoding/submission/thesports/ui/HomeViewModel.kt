package com.dicoding.submission.thesports.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.submission.thesports.core.domain.useCase.EventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: EventUseCase
): ViewModel() {
    val listEvent = useCase.getAllEvent().asLiveData()
}