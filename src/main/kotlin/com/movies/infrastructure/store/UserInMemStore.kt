package com.movies.infrastructure.store

import com.movies.domain.model.SelfManagedID
import com.movies.domain.model.User
import com.movies.domain.repository.UserRepository
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
class UserInMemStore(
    private val userMap: MutableMap<SelfManagedID, User> = HashMap()
) : UserRepository {

    override fun save(user: User): User {
        userMap[user.userId] = user
        return user
    }

    override fun updateUser(user: User) {
        userMap[user.userId] = user
        TODO("Not yet implemented")
    }

    override fun find(id: String): User {
        val managedId = SelfManagedID(id)
        if (!userMap.containsKey(managedId)) {
            throw Exception("Couldn't find id: $id")
        }
        return userMap[managedId]!!
    }
}