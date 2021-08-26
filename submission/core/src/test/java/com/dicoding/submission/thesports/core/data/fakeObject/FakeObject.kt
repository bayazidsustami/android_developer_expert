package com.dicoding.submission.thesports.core.data.fakeObject

import com.dicoding.submission.thesports.core.data.local.entity.EventEntity
import com.dicoding.submission.thesports.core.domain.model.EventDomainModel
import com.dicoding.submission.thesports.core.utils.DataMapper

object FakeObject {

    fun getListEvent(): List<EventEntity>{
        val events = mutableListOf<EventEntity>()

        events.add(
            EventEntity(
                "1234",
                "ddddd",
                "sssss",
                "xxxxxx",
                "ssss",
                "wwwww",
            "cdcdcd",
                "ffffff",
                "ggggg",
                "dddddss",
                "ssssss",
                "lllll",
                "ssss",
                "ddddd",
                "sssss",
                "rrrrr",
                false
            )
        )
        events.add(
            EventEntity(
                "1233",
                "ddddd",
                "sssss",
                "xxxxxx",
                "ssss",
                "wwwww",
                "cdcdcd",
                "ffffff",
                "ggggg",
                "dddddss",
                "ssssss",
                "lllll",
                "ssss",
                "ddddd",
                "sssss",
                "rrrrr",
                false
            )
        )
        events.add(
            EventEntity(
                "1233",
                "ddddd",
                "sssss",
                "xxxxxx",
                "ssss",
                "wwwww",
                "cdcdcd",
                "ffffff",
                "ggggg",
                "dddddss",
                "ssssss",
                "lllll",
                "ssss",
                "ddddd",
                "sssss",
                "rrrrr",
                false
            )
        )
        return events
    }

    fun getEntitiesToDomain(): List<EventDomainModel>{
        return DataMapper.mapEventEntitiesToDomain(getListEvent())
    }
}