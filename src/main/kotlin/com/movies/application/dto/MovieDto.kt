package com.movies.application.dto

class MovieDto(
    val title: String,
    val director: String,
    val genres: HashSet<String>,
    val avgRating: Double
) {
}