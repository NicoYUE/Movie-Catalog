package com.movies.domain.service.event

import com.movies.domain.model.event.*
import com.movies.domain.model.event.store.EventStore
import com.movies.domain.service.catalog.IAddSeeLater
import com.movies.domain.service.catalog.IAddSeen
import com.movies.domain.service.catalog.IRateMovie
import com.movies.domain.service.movie.ICreateMovie
import com.movies.domain.service.user.ICreateUser
import org.springframework.stereotype.Service

@Service
class ReplayEventService(
    private val createUserService: ICreateUser,
    private val createMovieService: ICreateMovie,
    private val addSeenService: IAddSeen,
    private val addSeeLaterService: IAddSeeLater,
    private val rateMovie: IRateMovie,
) : IReplayEvent {

    override fun replayAll(events: List<Event>) {

        for (event in events) {
            when (event) {
                is UserEvent -> createUserService.createUser(event.toUser())
                is MovieEvent -> createMovieService.createMovie(event.toMovie())
                is UpdateUserEvent -> when (event.eventType) {
                    "seen" -> addSeenService.addSeen(event.title, event.username)
                    "seeLater" -> addSeeLaterService.addSeeLater(event.title, event.username)
                }
                is RateEvent -> rateMovie.rate(event.username, event.title, event.rating)
            }
        }
    }
}