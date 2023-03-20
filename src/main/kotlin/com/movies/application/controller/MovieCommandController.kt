package com.movies.application.controller

import com.movies.application.dto.MovieDto
import com.movies.domain.command.movie.ICreateMovie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/movie")
class MovieCommandController(
    val createMovieService: ICreateMovie
) {

    @PostMapping("add")
    fun addUser(@RequestBody movieDto: MovieDto): ResponseEntity<String> {
        return movieDto.toDomain()
            .let { createMovieService.createMovie(it) }
            .let { ResponseEntity.ok("Movie ${it.title} directed by ${it.director} was created with ID ${it.movieId}") }
    }

}