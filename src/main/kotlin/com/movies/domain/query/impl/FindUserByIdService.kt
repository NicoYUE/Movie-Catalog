package com.movies.domain.query.impl

import com.movies.domain.model.User
import com.movies.domain.query.IFindUserByUsername
import com.movies.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class FindUserByIdService(val userRepository: UserRepository) : IFindUserByUsername {

    override fun findUserByUsername(username: String): User {
        return userRepository.find(username) ?: throw Exception("User $username not found")
    }
}