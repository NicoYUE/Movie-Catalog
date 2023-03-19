package com.movies.domain.repository

import com.movies.domain.model.User
import java.util.*

interface UserRepository {

    fun save(user: User): User
    fun find(username: String): Optional<User>
}