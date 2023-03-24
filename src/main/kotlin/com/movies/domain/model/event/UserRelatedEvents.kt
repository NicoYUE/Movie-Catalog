package com.movies.domain.model.event

import com.movies.domain.model.User

class UserRelatedEvents {

    data class UserEvent(
        val eventAction: EventAction,
        val username: String,
        val seen: List<String>,
        val seeLater: List<String>
    ) : Event
    data class AddSeenEvent(
        val eventAction: EventAction = EventAction.UPDATE,
        val username: String,
        val title: String,
        val eventType: String = "seen"
    ) : Event

    data class AddSeeLaterEvent(
        val eventAction: EventAction = EventAction.UPDATE,
        val username: String,
        val title: String,
        val eventType: String = "seeLater"
    ) : Event
}