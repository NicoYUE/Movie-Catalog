package com.movies.domain.repository

interface CatalogRepository {

    fun rate(username: String, title: String, rating: Double)
}