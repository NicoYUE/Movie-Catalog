package com.movies.domain.model.event

import com.movies.domain.model.Genre
import com.movies.domain.model.Movie

data class MovieEvent(
    val eventAction: EventAction,
    val title: String,
    val director: String,
    val genres: Set<Genre>
) : Event {

    fun toMovie(): Movie = Movie(title, director, genres, 0.0)
}