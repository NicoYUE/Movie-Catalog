package com.movies.domain.command.user

import com.movies.domain.model.User

interface ICreateUser {

    fun createUser(user: User): User
}