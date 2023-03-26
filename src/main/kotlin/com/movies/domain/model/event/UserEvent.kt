package com.movies.domain.model.event

import com.movies.domain.model.User

data class UserEvent(
    val eventAction: EventAction,
    val username: String,
    val seen: List<String>,
    val seeLater: List<String>
) : Event {
    fun toUser(): User = User(username, seen.toMutableList(), seeLater.toMutableList())

}