package com.dicoding.submission.thesports.core.data.remote.network

import com.dicoding.submission.thesports.core.data.remote.response.EventResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("eventspastleague.php")
    suspend fun getListEvent(
        @Query("id") idLeague: String = "4328"
    ): EventResponse
}