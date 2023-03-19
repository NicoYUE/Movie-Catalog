package com.movies.application.controller

import com.movies.application.dto.UserDto
import com.movies.domain.cqrs.command.user.ICreateUser
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserCommandController(val createUserService: ICreateUser) {

    @PostMapping("add")
    fun addUser(@RequestBody userDto: UserDto): ResponseEntity<String> {
        return userDto.toDomain()
            .let { createUserService.createUser(it) }
            .let { ResponseEntity.ok("User ${it.username} created with ID ${it.userId}") }
    }

}