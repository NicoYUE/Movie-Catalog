package com.movies.domain.model.event

data class RateEvent(
    val eventAction: EventAction,
    val username: String,
    val title: String,
    val rating: Double
) : Event