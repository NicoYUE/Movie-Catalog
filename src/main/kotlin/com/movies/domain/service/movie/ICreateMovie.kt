package com.movies.domain.service.movie

import com.movies.domain.model.Movie

interface ICreateMovie {

    fun createMovie(movie: Movie): Movie
}