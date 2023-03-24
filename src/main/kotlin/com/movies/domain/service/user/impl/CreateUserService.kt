package com.movies.domain.cqrs.command.user.impl

import com.movies.domain.model.User
import com.movies.domain.repository.UserRepository
import com.movies.domain.service.user.ICreateUser
import org.springframework.stereotype.Service

@Service
class CreateUserService(val userRepository: UserRepository): ICreateUser {

    override fun createUser(user: User): User {
        userRepository.find(user.username)?.let { throw Exception("User ${it.username} already exists") }
        return userRepository.save(user)
    }
}