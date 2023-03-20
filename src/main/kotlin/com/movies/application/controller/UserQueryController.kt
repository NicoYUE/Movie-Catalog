package com.movies.application.controller

import com.movies.application.dto.UserDto
import com.movies.application.dto.UserDto.Companion.fromDomain
import com.movies.domain.query.IFindUserByUsername
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserQueryController(
    val findUserByIdService: IFindUserByUsername
) {

    // TODO find better verbs
    @GetMapping("/get")
    fun getUserById(@RequestBody id: String): UserDto {
        return id
            .let { findUserByIdService.findUserByUsername(it) }
            .let { fromDomain(it) }
    }
}