package com.movies.domain.service.user

import com.movies.domain.model.User

interface ICreateUser {

    fun createUser(user: User): User
}