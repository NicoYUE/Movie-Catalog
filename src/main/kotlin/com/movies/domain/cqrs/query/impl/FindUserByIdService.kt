package com.movies.domain.cqrs.query.impl

import com.movies.domain.cqrs.query.IFindUserById
import com.movies.domain.model.User
import com.movies.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class FindUserByIdService(val userRepository: UserRepository) : IFindUserById {

    override fun findUserById(id: String): User {
        return id.let { userRepository.findUserById(it) }
    }
}