package com.dicoding.submission.thesports.core.utils

import com.dicoding.submission.thesports.core.data.local.entity.EventEntity
import com.dicoding.submission.thesports.core.data.remote.response.EventsItem
import com.dicoding.submission.thesports.core.domain.model.EventDomainModel

object DataMapper {
    private inline fun <I, O> mapList(input: List<I>, mapListItem: (I) -> O): List<O> {
        return input.map { mapListItem(it) }
    }

    private inline fun <I, O> mapNullInputList(input: List<I>?, mapListItem: (I) -> O): List<O> {
        return input?.map { mapListItem(it) } ?: emptyList()
    }

    private inline fun <I, O> mapNullOutputList(input: List<I>, mapListItem: (I) -> O): List<O>? {
        return if (input.isEmpty()) null else input.map { mapListItem(it) }
    }

    fun mapEventEntitiesToDomain(entities: List<EventEntity>): List<EventDomainModel>{
        return mapList(entities) { event ->
            EventDomainModel(
                idEvent = event.idEvent,
                idLeague = event.idLeague,
                idHomeTeam = event.idHomeTeam,
                idAwayTeam = event.idAwayTeam,
                eventName = event.eventName,
                leagueName = event.leagueName,
                season = event.season,
                homeTeam = event.homeTeam,
                awayTeam = event.awayTeam,
                homeScore = event.homeScore,
                awayScore = event.awayScore,
                dataEvent = event.dataEvent,
                timeEvent = event.timeEvent,
                venue = event.venue,
                country = event.country,
                thumbnail = event.thumbnail,
                isFavorite = event.isFavorite
            )
        }
    }

    fun mapEventResponsesToEntities(responses: List<EventsItem>): List<EventEntity>{
        return mapNullInputList(responses){response ->
            EventEntity(
                idEvent = response.idEvent ?: "",
                idLeague = response.idLeague ?: "",
                idHomeTeam = response.idHomeTeam ?: "",
                idAwayTeam = response.idAwayTeam ?: "",
                eventName = response.strEvent ?: "",
                leagueName = response.strLeague ?: "",
                season = response.strSeason ?: "",
                homeTeam = response.strHomeTeam ?: "",
                awayTeam = response.strAwayTeam ?: "",
                homeScore = response.intHomeScore ?: "",
                awayScore = response.intAwayScore ?: "",
                dataEvent = response.dateEvent ?: "",
                timeEvent = response.strTime ?: "",
                venue = response.strVenue ?: "",
                country = response.strCountry ?: "",
                thumbnail = response.strThumb ?: "",
                isFavorite = false
            )
        }
    }

    fun mapEventDomainToEntity(data: EventDomainModel): EventEntity{
        return EventEntity(
            idEvent = data.idEvent,
            idLeague = data.idLeague,
            idHomeTeam = data.idHomeTeam,
            idAwayTeam = data.idAwayTeam,
            eventName = data.eventName,
            leagueName = data.leagueName,
            season = data.season,
            homeTeam = data.homeTeam,
            awayTeam = data.awayTeam,
            homeScore = data.homeScore,
            awayScore = data.awayScore,
            dataEvent = data.dataEvent,
            timeEvent = data.timeEvent,
            venue = data.venue,
            country = data.country,
            thumbnail = data.thumbnail,
            isFavorite = data.isFavorite
        )
    }
}