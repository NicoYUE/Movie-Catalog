package com.movies.infrastructure.cassandra

import org.springframework.data.cassandra.repository.CassandraRepository

interface ImportedUserCassandraRepository: CassandraRepository<UserCassandraEntity, String> {
}