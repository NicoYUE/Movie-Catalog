package com.movies.application.controller

import com.movies.application.dto.AddSeenCommand
import com.movies.domain.command.user.IAddSeen
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/catalog")
class CatalogCommandController
    (val addSeenService: IAddSeen) {

    @PostMapping("addSeen")
    fun addUser(@RequestBody seenCommand: AddSeenCommand): ResponseEntity<String> {
        addSeenService.addSeen(seenCommand.movieTitle, seenCommand.movieTitle)
        return ResponseEntity.ok("Successfully added ${seenCommand.movieTitle} to ${seenCommand.username}")
    }
}