package com.movies.domain.model.event

data class UpdateUserEvent(
    val eventAction: EventAction = EventAction.UPDATE,
    val username: String,
    val title: String,
    val eventType: String
) : Event
{

}