package com.dicoding.course.mysimplecleanarch.domain

interface IMessageRepository {
    fun getWelcomeMessage(name: String): MessageEntity
}