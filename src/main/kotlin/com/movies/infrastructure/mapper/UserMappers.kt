package com.movies.infrastructure.mapper

import com.movies.domain.model.User
import com.movies.infrastructure.cassandra.UserCassandraEntity
import com.movies.infrastructure.sql.entity.UserEntity

class UserMappers {
    companion object {

        fun fromSqlEntity(userEntity: UserEntity): User {
            return User(userEntity.userId, userEntity.username, userEntity.seen, userEntity.seeLater)
        }

        fun toSqlEntity(user: User): UserEntity {
            return UserEntity(user.userId, user.username, user.seen, user.seen)
        }

        fun fromCassandraEntity(userCassandraEntity: UserCassandraEntity): User =
            User(
                userCassandraEntity.id,
                userCassandraEntity.username,
                userCassandraEntity.seen ?: emptyList(),
                userCassandraEntity.seeLater ?: emptyList()
            )

        fun toCassandraEntity(user: User): UserCassandraEntity {
            return UserCassandraEntity(user.username, user.userId.id, user.seen, user.seeLater)
        }
    }
}