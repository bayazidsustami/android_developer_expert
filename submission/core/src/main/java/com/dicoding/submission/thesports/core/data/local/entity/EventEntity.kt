package com.dicoding.submission.thesports.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_entity")
data class EventEntity(
    @PrimaryKey
    val idEvent: String
)
