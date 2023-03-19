package com.movies.domain.repository

import com.movies.domain.model.Movie

interface MovieRepository {

    fun addMovie(movie: Movie)
    fun deleteMovie(movie: Movie)
}