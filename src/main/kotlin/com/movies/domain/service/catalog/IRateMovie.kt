package com.movies.domain.service.catalog

interface IRateMovie {

    fun rate(username: String, title: String, rating: Double)
}