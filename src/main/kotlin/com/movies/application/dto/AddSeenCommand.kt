package com.movies.application.dto

data class AddSeenCommand(
    val username: String,
    val movieTitle: String
)