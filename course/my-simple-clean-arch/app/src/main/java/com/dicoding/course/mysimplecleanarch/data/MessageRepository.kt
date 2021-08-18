package com.dicoding.course.mysimplecleanarch.data

import com.dicoding.course.mysimplecleanarch.domain.IMessageRepository
import com.dicoding.course.mysimplecleanarch.domain.MessageEntity

class MessageRepository(
    private val dataSource: IMessageDataSource
): IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity {
        return dataSource.getMessageFromSource(name)
    }
}