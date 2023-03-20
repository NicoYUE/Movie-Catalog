package com.movies.infrastructure.cassandra.imported

import com.movies.infrastructure.cassandra.entity.UserCassandraEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import java.util.*

interface ImportedUserCassandraRepository : CassandraRepository<UserCassandraEntity, String> {

    fun findOneByUsername(username: String): UserCassandraEntity?
}