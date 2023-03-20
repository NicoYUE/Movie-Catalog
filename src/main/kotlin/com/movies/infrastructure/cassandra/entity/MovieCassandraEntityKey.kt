package com.movies.infrastructure.cassandra.entity

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn

@PrimaryKeyClass
data class MovieCassandraEntityKey(
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    val title: String,
    @PrimaryKeyColumn(ordinal = 0)
    val director: String
)