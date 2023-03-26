package com.movies.infrastructure.sql.entity

import com.movies.domain.model.SelfManagedID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
data class UserEntity(
    @Id
    val userId: SelfManagedID,
    @Column(unique = true)
    val username: String,
    val seen: MutableList<String>,
    val seeLater: MutableList<String>
)