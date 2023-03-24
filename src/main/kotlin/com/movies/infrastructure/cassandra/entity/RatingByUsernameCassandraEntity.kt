package com.movies.infrastructure.cassandra.entity

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table(value = "rating_by_username")
data class RatingByUsernameCassandraEntity(
    @PrimaryKey
    val username: String,
    val title: String,
    val rating: Double
) {
}