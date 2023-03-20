package com.movies.domain.command.movie.impl

import com.movies.domain.command.movie.ICreateMovie
import com.movies.domain.model.Movie
import com.movies.domain.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class CreateMovieService(val movieRepository: MovieRepository): ICreateMovie {

    override fun createMovie(movie: Movie): Movie {
        movieRepository.find(movie.title)
            ?.let { throw Exception("Movie ${it.title} already exists") }
        return movieRepository.save(movie)
    }
}