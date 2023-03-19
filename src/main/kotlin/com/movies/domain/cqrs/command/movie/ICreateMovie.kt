package com.movies.domain.cqrs.command.movie

import com.movies.domain.model.Movie

interface ICreateMovie {

    fun createMovie(movie: Movie)
}