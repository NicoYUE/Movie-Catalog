package com.movies.infrastructure.cassandra

import com.movies.domain.repository.UserRepository
import org.springframework.data.cassandra.repository.CassandraRepository
import java.util.*

interface ImportedUserCassandraRepository: UserRepository, CassandraRepository<UserCassandraEntity, String> {

    fun findOneByUsername(username: String): Optional<UserCassandraEntity>
}