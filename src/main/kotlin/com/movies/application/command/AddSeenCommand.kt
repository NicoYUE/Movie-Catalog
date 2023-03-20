package com.movies.application.command

data class AddSeenCommand(
    val username: String,
    val movieTitle: String
)