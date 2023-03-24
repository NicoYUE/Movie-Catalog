package com.movies.infrastructure.cassandra

import com.movies.domain.model.Movie
import com.movies.domain.repository.MovieRepository
import com.movies.infrastructure.cassandra.imported.ImportedMovieCassandraRepository
import com.movies.infrastructure.mapper.MovieMappers.Companion.fromCassandraEntity
import com.movies.infrastructure.mapper.MovieMappers.Companion.toCassandraEntity
import org.springframework.stereotype.Repository

@Repository
class MovieCassandraRepository(
    val cassandraRepository: ImportedMovieCassandraRepository
) : MovieRepository {

    override fun save(movie: Movie): Movie {
        return toCassandraEntity(movie)
            .let { cassandraRepository.insert(it) }
            .let { fromCassandraEntity(it) }
    }

    override fun find(title: String): Movie? {
        return cassandraRepository.findByKeyTitle(title)
            ?.let { fromCassandraEntity(it) }
    }
}