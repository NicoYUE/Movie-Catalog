package com.movies.domain.query

import com.movies.domain.model.User

interface IFindUserByUsername {

    fun findUserByUsername(username: String): User
}