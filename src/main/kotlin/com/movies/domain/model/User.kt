package com.movies.domain.model

data class User(
    val userId: SelfManagedID,
    val username: String,
    val seen: MutableList<String> = mutableListOf(),
    val seeLater: MutableList<String> = mutableListOf()
) {
    constructor(username: String, seen: MutableList<String>, seeLater: MutableList<String>) :
            this(SelfManagedID(), username, seen, seeLater)

    constructor(id: String, username: String, seen: MutableList<String>, seeLater: MutableList<String>) :
            this(SelfManagedID(id), username, seen, seeLater)
}