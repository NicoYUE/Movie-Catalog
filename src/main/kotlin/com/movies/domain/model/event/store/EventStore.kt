package com.movies.domain.model.event.store

import com.fasterxml.jackson.databind.ObjectMapper
import com.movies.domain.model.event.*
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
data class EventStore(
    private val objectMapper: ObjectMapper
) {

    private val eventStore: MutableList<Event> = mutableListOf()

    @EventListener(ApplicationReadyEvent::class)
    fun init(e: ApplicationReadyEvent) {
        loadEvent<UserEvent>("/events/user-events.json").forEach { eventStore.add(it) }
        loadEvent<MovieEvent>("/events/movie-events.json").forEach { eventStore.add(it) }
        loadEvent<UpdateUserEvent>("/events/user-update-events.json").forEach { eventStore.add(it) }
        loadEvent<RateEvent>("/events/rate-events.json").forEach { eventStore.add(it) }
    }

    private inline fun <reified T> loadEvent(path: String): List<T> {
        val rateEventText = EventStore::class.java.getResource(path)
            ?.readText()
            ?: throw Exception("File " + path + "not found")

        val constructCollectionType = objectMapper.typeFactory.constructCollectionType(List::class.java, T::class.java)
        return objectMapper.readValue(rateEventText, constructCollectionType)
    }

    fun getStore(): List<Event> {
        return eventStore.toList()
    }
}