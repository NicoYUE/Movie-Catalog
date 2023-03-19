package com.movies.domain.cqrs.query

import com.movies.domain.model.User

interface IFindUserById {

    fun findUserById(id: String): User
}