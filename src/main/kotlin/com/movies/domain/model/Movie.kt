package com.movies.domain.model

data class Movie(
    val movieId: SelfManagedID,
    val title: String,
    val director: String,
    val genres: Set<Genre> = emptySet(),
    val avgRating: Double = 0.0
) {
    constructor(title: String, director: String, genres: Set<Genre>, avgRating: Double) :
            this(SelfManagedID(), title, director, genres, avgRating)

    constructor(movieId: String, title: String, director: String, genres: Set<Genre>, avgRating: Double) :
            this(SelfManagedID(movieId), title, director, genres, avgRating)
}