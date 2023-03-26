package com.movies.domain.repository

interface RateRepository {
    fun rate(username: String, title: String, rating: Double)
}