package com.movies.infrastructure.cassandra.entity

import org.springframework.data.cassandra.core.cql.Ordering
import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table

@Table(value = "rating_by_username")
data class RatingByUsernameCassandraEntity(
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    val username: String,
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    val title: String,
    val rating: Double
)