package com.movies.domain.cqrs.command.user

interface IAddSeen {

    fun addSeen(movieId: String, userId: String)
}