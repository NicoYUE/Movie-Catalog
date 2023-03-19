package com.movies.domain.cqrs.command.movie

interface IDeleteMovieById {

    fun delete(id: String)
}