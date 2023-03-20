package com.movies.domain.cqrs.command.user

interface IAddSeeLater {

    fun addSeeLater(movieId: String, userId: String)
}