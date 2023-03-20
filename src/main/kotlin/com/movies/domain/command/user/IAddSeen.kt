package com.movies.domain.command.user

interface IAddSeen {

    fun addSeen(title: String, username: String)
}