//package com.movies.domain.cqrs.command.user.impl
//
//import com.movies.domain.cqrs.command.user.IAddSeen
//import com.movies.domain.repository.UserRepository
//import org.springframework.stereotype.Service
//
//@Service
//class AddSeenService(val userRepository: UserRepository) : IAddSeen {
//
//    override fun addSeen(movieId: String, userId: String) {
//        val userById = userRepository.getUserById(userId)
//        userById.seen.plus(movieId)
//        userRepository.updateUser(userById)
//    }
//}