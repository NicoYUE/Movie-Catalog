package com.movies.application.dto

import com.movies.domain.model.Genre
import com.movies.domain.model.Movie

data class MovieDto(
    val title: String,
    val director: String,
    val genres: HashSet<String>,
    val avgRating: Double?
) {

    fun toDomain(): Movie {
        return Movie(
            title,
            director,
            genres = genres.mapNotNull { Genre.fromString(it) }.toHashSet(),
            avgRating ?: 0.0
        )
    }

    companion object {
        fun fromDomain(movie: Movie): MovieDto = MovieDto(
            movie.title,
            movie.director,
            genres = movie.genres.map { it.name }.toHashSet(),
            movie.avgRating
        )
    }
}