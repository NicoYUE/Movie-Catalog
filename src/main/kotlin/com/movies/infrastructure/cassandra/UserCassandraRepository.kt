package com.movies.infrastructure.cassandra

import com.movies.domain.model.User
import com.movies.domain.repository.UserRepository
import com.movies.infrastructure.mapper.UserMappers.Companion.fromCassandraEntity
import com.movies.infrastructure.mapper.UserMappers.Companion.toCassandraEntity
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository
import java.util.*

@Primary
@Repository
class UserCassandraRepository(
    val cassandraRepository: ImportedUserCassandraRepository
) : UserRepository {

    override fun save(user: User): User {
        return toCassandraEntity(user)
            .let { cassandraRepository.insert(it) }
            .let { fromCassandraEntity(it) }
    }

    override fun find(username: String): Optional<User> {
        return cassandraRepository.findOneByUsername(username)
            .map { entity -> fromCassandraEntity(entity) }
    }
}