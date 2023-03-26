package com.movies.infrastructure.cassandra.entity

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table(value = "user")
data class UserCassandraEntity(
    @PrimaryKey
    val username: String,
    val id: String,
    val seen: MutableList<String>?,
    val seeLater: MutableList<String>?
)