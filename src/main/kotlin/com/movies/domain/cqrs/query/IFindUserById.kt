package com.movies.domain.cqrs.query

import com.movies.domain.model.User

interface IFindUserByUsername {

    fun findUserByUsername(username: String): User
}