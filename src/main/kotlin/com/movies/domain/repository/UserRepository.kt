package com.movies.domain.repository

import com.movies.domain.model.User

interface UserRepository {

    fun addUser(user: User): User
    fun updateUser(user: User): User
    fun findUserById(id: String): User
}