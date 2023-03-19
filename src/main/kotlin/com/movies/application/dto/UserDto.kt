package com.movies.application.dto

import com.movies.domain.model.User

data class UserDto(
    val id: String?,
    val username: String,
    val seen: List<String>,
    val seeLater: List<String>
) {
    fun toDomain(): User {
        return User(username, seen, seeLater)
    }

    companion object {
        fun fromDomain(user: User): UserDto = UserDto(user.userId.id, user.username, user.seen, user.seeLater)
    }
}