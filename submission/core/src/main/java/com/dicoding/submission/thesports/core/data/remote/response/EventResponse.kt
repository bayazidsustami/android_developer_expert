package com.dicoding.submission.thesports.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class EventResponse(

	@field:SerializedName("events")
	val events: List<EventsItem>
)