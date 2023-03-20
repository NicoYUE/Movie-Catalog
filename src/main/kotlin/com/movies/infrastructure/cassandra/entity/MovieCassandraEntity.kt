package com.movies.infrastructure.cassandra.entity

import com.movies.domain.model.Genre
import org.springframework.data.cassandra.core.cql.Ordering
import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table

@Table(value = "movie")
data class MovieCassandraEntity(
    val id: String,
    @PrimaryKey
    val key: MovieCassandraEntityKey,
    val genres: List<Genre>?,
    val avgRating: Double = 0.0
)