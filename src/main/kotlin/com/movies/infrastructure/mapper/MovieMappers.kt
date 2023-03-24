package com.movies.infrastructure.mapper

import com.movies.domain.model.Movie
import com.movies.domain.model.SelfManagedID
import com.movies.infrastructure.cassandra.entity.MovieCassandraEntity
import com.movies.infrastructure.cassandra.entity.MovieCassandraEntityKey

class MovieMappers {
    companion object {
        fun fromCassandraEntity(movieCassandraEntity: MovieCassandraEntity): Movie {

            val movieKey = movieCassandraEntity.key

            return Movie(
                movieCassandraEntity.id,
                movieKey.title,
                movieKey.director,
                movieCassandraEntity.genres?.toSet() ?: emptySet(),
                movieCassandraEntity.avgRating
            )
        }

        fun toCassandraEntity(movie: Movie): MovieCassandraEntity {
            return MovieCassandraEntity(
                movie.movieId.id,
                MovieCassandraEntityKey(movie.title, movie.director),
                movie.genres.toList(),
                movie.avgRating
            )
        }
    }
}