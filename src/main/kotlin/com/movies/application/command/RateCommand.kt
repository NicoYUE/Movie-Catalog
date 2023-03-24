package com.movies.application.command

import com.movies.application.dto.Rating

data class RateCommand(
    val username: String,
    val movieTitle: String,
    val rating: Rating
) {
}