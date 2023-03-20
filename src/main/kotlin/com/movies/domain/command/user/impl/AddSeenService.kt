package com.movies.domain.cqrs.command.user.impl

import com.movies.domain.command.user.IAddSeen
import com.movies.domain.repository.MovieRepository
import com.movies.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AddSeenService(
    val userRepository: UserRepository,
    val movieRepository: MovieRepository
) : IAddSeen {

    override fun addSeen(title: String, username: String) {

        movieRepository.find(title) ?: throw Exception("Movie $title does not exist")
        val user = userRepository.find(username) ?: throw Exception("User $username does not exist")

        user.seen.plus(title)
        userRepository.save(user)
    }
}