package com.movies.domain.command.movie

interface IDeleteMovieById {

    fun delete(id: String)
}