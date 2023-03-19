package com.movies.domain.model

data class Movie(
    val id: String,
    val title: String,
    val director: String,
    val genres: Set<Genre>,
    val avgRating: Double
)