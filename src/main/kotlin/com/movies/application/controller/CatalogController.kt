package com.movies.application.controller

import com.movies.application.command.AddSeenCommand
import com.movies.application.command.RateCommand
import com.movies.domain.service.catalog.CatalogService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/catalog")
class CatalogController(
     val catalogService: CatalogService) {

    @PostMapping("addSeen")
    fun addUser(@RequestBody seenCommand: AddSeenCommand): ResponseEntity<String> {
        catalogService.addSeen(seenCommand.movieTitle, seenCommand.movieTitle)
        return ResponseEntity.ok("Successfully added ${seenCommand.movieTitle} to ${seenCommand.username}")
    }

    @PostMapping("rateMovie")
    fun rate(@RequestBody rateCommand: RateCommand): ResponseEntity<String> {
        rateCommand.let { catalogService.rateMovie(it.username, it.movieTitle, it.rating) }
        return ResponseEntity.ok("User ${rateCommand.username} rated movie ${rateCommand.movieTitle} : ${rateCommand.rating}")
    }
}