package com.movies.infrastructure.cassandra.imported

import com.movies.infrastructure.cassandra.entity.MovieCassandraEntity
import com.movies.infrastructure.cassandra.entity.MovieCassandraEntityKey
import org.springframework.data.cassandra.repository.CassandraRepository

interface ImportedMovieCassandraRepository : CassandraRepository<MovieCassandraEntity, MovieCassandraEntityKey> {
    fun findByKeyTitle(title: String): MovieCassandraEntity?
}