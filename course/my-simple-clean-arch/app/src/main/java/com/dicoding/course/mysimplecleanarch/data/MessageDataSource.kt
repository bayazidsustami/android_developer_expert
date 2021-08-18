package com.dicoding.course.mysimplecleanarch.data

import com.dicoding.course.mysimplecleanarch.domain.MessageEntity

class MessageDataSource: IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity {
        return MessageEntity("Hello $name! Welcome to Clean Architecture")
    }
}