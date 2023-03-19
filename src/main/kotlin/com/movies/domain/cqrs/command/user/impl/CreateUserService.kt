package com.movies.domain.cqrs.command.user.impl

import com.movies.domain.model.User
import com.movies.domain.repository.UserRepository
import com.movies.domain.cqrs.command.user.ICreateUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateUserService: ICreateUser {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun createUser(user: User): User {
        return userRepository.addUser(user)
    }
}