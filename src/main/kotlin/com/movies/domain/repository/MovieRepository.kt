package com.movies.domain.repository

import com.movies.domain.model.Movie
import java.util.Optional

interface MovieRepository {

    fun save(movie: Movie): Movie

    fun find(title: String): Movie?
}