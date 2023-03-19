package com.movies.infrastructure.cassandra

import com.movies.domain.model.User
import com.movies.domain.repository.UserRepository
import com.movies.infrastructure.mapper.UserMappers.Companion.fromCassandraEntity
import com.movies.infrastructure.mapper.UserMappers.Companion.toCassandraEntity
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository

@Primary
@Repository
class UserCassandraRepository(
    val cassandraRepository: ImportedUserCassandraRepository
) : UserRepository {

    override fun addUser(user: User): User {

        cassandraRepository.findById(user.username)
            .ifPresent {
                throw Exception("User ${user.username} already exists.")
            }

        return toCassandraEntity(user)
            .let { cassandraRepository.insert(it) }
            .let { fromCassandraEntity(it) }
    }

    override fun updateUser(user: User): User {
        val actualUser = cassandraRepository.findById(user.username)

        if (actualUser.isPresent) {
            val updatedUser = actualUser.get().copy(
                seen = user.seen,
                seeLater = user.seeLater
            )

            return updatedUser
                .let { cassandraRepository.insert(it) }
                .let { fromCassandraEntity(it) }
        }
        throw Exception("No user found for ${user.userId.id}")
    }

    override fun findUserById(id: String): User {
        val userEntity = cassandraRepository.findById(id)
        if (userEntity.isPresent) {
            return fromCassandraEntity(userEntity.get())
        }
        throw Exception("No user found for $id")
    }
}