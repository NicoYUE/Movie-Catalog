package com.movies.domain.model

import java.util.*

data class SelfManagedID(
    val id: String = UUID.randomUUID().toString().uppercase()
)