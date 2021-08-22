package com.dicoding.submission.thesports.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventDomainModel(
    val idEvent: String,
    val idLeague: String,
    val idHomeTeam: String,
    val idAwayTeam: String,
    val eventName: String,
    val leagueName: String,
    val season: String,
    val homeTeam: String,
    val awayTeam: String,
    val homeScore: String,
    val awayScore: String,
    val dataEvent: String,
    val timeEvent: String,
    val venue: String,
    val country: String,
    val thumbnail: String,
    var isFavorite: Boolean
): Parcelable
