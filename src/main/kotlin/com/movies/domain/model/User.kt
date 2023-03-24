package com.movies.domain.model

data class User(
    val userId: SelfManagedID,
    val username: String,
    val seen: List<String> = emptyList(),
    val seeLater: List<String> = emptyList()
) {
    constructor(username: String, seen: List<String>, seeLater: List<String>) :
            this(SelfManagedID(), username, seen, seeLater)

    constructor(id: String, username: String, seen: List<String>, seeLater: List<String>) :
            this(SelfManagedID(id), username, seen, seeLater)
}