package com.dicoding.course.mysimplecleanarch.di

import com.dicoding.course.mysimplecleanarch.data.IMessageDataSource
import com.dicoding.course.mysimplecleanarch.data.MessageDataSource
import com.dicoding.course.mysimplecleanarch.data.MessageRepository
import com.dicoding.course.mysimplecleanarch.domain.IMessageRepository
import com.dicoding.course.mysimplecleanarch.domain.MessageInteractor
import com.dicoding.course.mysimplecleanarch.domain.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase{
        val repository = provideRepository()
        return MessageInteractor(repository)
    }

    private fun provideRepository(): IMessageRepository{
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource{
        return MessageDataSource()
    }
}