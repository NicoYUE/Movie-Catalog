package com.movies.domain.model.event.store

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.movies.domain.model.event.Event
import com.movies.domain.model.event.MovieEvent
import com.movies.domain.model.event.UserRelatedEvents.AddSeenEvent
import com.movies.domain.model.event.UserRelatedEvents.UserEvent
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
data class EventStore(
    val objectMapper: ObjectMapper,
) {

    private val events: MutableList<Event> = mutableListOf()

    @EventListener(ApplicationReadyEvent::class)
    fun init(e: ApplicationReadyEvent) {

        val userEventsText = EventStore::class.java.getResource("/events/user-events.json")
            ?.readText()
            ?: throw Exception("No such file")
        objectMapper.readValue<List<UserEvent>>(userEventsText)
            .forEach { events.add(it) }

        val movieEventsText = EventStore::class.java.getResource("/events/movie-events.json")
            ?.readText()
            ?: throw Exception("No such file")
        objectMapper.readValue<List<MovieEvent>>(movieEventsText)
            .forEach { events.add(it) }

        val userUpdateEventText = EventStore::class.java.getResource("/events/user-update-events.json")
            ?.readText()
            ?: throw Exception("No such file")
        objectMapper.readValue<List<AddSeenEvent>>(userUpdateEventText)
            .forEach { events.add(it) }

        println()
    }
}