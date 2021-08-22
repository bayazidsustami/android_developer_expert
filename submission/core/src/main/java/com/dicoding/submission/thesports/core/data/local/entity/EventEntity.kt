package com.dicoding.submission.thesports.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_entity")
data class EventEntity(
    @PrimaryKey
    @NonNull
    val idEvent: String,
    @ColumnInfo(name = "id_league") val idLeague: String,
    @ColumnInfo(name = "id_home_team") val idHomeTeam: String,
    @ColumnInfo(name = "id_away_team") val idAwayTeam: String,
    @ColumnInfo(name = "event_name") val eventName: String,
    @ColumnInfo(name = "league_name") val league_name: String,
    @ColumnInfo(name = "season") val season: String,
    @ColumnInfo(name = "home_team") val homeTeam: String,
    @ColumnInfo(name = "away_team") val awayTeam: String,
    @ColumnInfo(name = "home_score") val homeScore: String,
    @ColumnInfo(name = "away_score") val awayScore: String,
    @ColumnInfo(name = "data_event") val dataEvent: String,
    @ColumnInfo(name = "time_event") val timeEvent: String,
    @ColumnInfo(name = "venue") val venue: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String
)
