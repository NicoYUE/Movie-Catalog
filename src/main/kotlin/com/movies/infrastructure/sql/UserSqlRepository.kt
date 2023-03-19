//package com.movies.infrastructure.sql
//
//import com.movies.domain.model.SelfManagedID
//import com.movies.domain.model.User
//import com.movies.domain.repository.UserRepository
//import com.movies.infrastructure.mapper.UserMappers
//import com.movies.infrastructure.mapper.UserMappers.Companion.fromSqlEntity
//import com.movies.infrastructure.mapper.UserMappers.Companion.toSqlEntity
//import com.movies.infrastructure.sql.entity.UserEntity
//import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.stereotype.Repository
//
//@Repository
//class UserSqlRepository(
//    val jpaRepository: JpaRepository<UserEntity, SelfManagedID>
//) : UserRepository {
//
//    override fun addUser(user: User): User {
//        val savedUserEntity = toSqlEntity(user).let { jpaRepository.saveAndFlush(it) }
//        return fromSqlEntity(savedUserEntity)
//    }
//
//    override fun updateUser(user: User) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getUserById(id: String): User {
//        TODO("Not yet implemented")
//    }
//}