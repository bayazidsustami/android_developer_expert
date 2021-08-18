package com.dicoding.course.mysimplecleanarch.domain

interface MessageUseCase {
    fun getMessage(name: String): MessageEntity
}