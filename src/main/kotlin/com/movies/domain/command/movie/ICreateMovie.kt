package com.movies.domain.command.movie

import com.movies.domain.model.Movie

interface ICreateMovie {

    fun createMovie(movie: Movie): Movie
}