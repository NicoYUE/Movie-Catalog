package com.movies.infrastructure.cassandra

import com.movies.domain.model.User
import com.movies.domain.repository.UserRepository
import com.movies.infrastructure.cassandra.imported.ImportedUserCassandraRepository
import com.movies.infrastructure.mapper.UserMappers.Companion.fromCassandraEntity
import com.movies.infrastructure.mapper.UserMappers.Companion.toCassandraEntity
import org.springframework.stereotype.Repository

@Repository
class UserCassandraRepository(
    val cassandraRepository: ImportedUserCassandraRepository
) : UserRepository {

    override fun save(user: User): User {
        return toCassandraEntity(user)
            .let { cassandraRepository.insert(it) }
            .let { fromCassandraEntity(it) }
    }

    override fun find(username: String): User? {
        return cassandraRepository.findOneByUsername(username)
            ?.let { fromCassandraEntity(it) }
    }
}