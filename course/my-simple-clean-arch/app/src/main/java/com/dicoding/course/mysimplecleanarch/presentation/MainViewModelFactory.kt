package com.dicoding.course.mysimplecleanarch.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.course.mysimplecleanarch.di.Injection
import com.dicoding.course.mysimplecleanarch.domain.MessageUseCase

class MainViewModelFactory(
    private val useCase: MessageUseCase
): ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var instance: MainViewModelFactory? = null

        fun getInstance(): MainViewModelFactory =
            instance ?: synchronized(this){
                instance ?: MainViewModelFactory(Injection.provideUseCase())
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java)  -> MainViewModel(useCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class: "+ modelClass.name)
        }
    }
}