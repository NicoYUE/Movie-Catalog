package com.movies.domain.model.event

import com.movies.domain.model.Genre
import com.movies.domain.model.Movie
import com.movies.domain.model.SelfManagedID

data class MovieEvent(
    val eventAction: EventAction,
    val title: String,
    val director: String,
    val genres: Set<Genre>
) : Event