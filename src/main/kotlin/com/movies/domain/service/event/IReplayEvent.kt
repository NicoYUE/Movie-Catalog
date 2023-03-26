package com.movies.domain.service.event

import com.movies.domain.model.event.Event


interface IReplayEvent {

    fun replayAll(events: List<Event>)
}