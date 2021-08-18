package com.dicoding.course.mysimplecleanarch.data

import com.dicoding.course.mysimplecleanarch.domain.MessageEntity

interface IMessageDataSource {
    fun getMessageFromSource(name: String): MessageEntity
}