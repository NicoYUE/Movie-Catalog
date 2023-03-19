package com.movies.domain.repository

import com.movies.domain.model.Movie

interface MovieRepository {

    fun save(movie: Movie): Movie
    fun find(key: String): Movie
    fun delete(movie: Movie)
}