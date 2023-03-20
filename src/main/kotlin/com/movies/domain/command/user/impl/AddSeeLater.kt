//package com.movies.domain.cqrs.command.user.impl
//
//import com.movies.domain.cqrs.command.user.IAddSeeLater
//import com.movies.domain.repository.UserRepository
//import org.springframework.stereotype.Service
//
//@Service
//class AddSeeLater(val userRepository: UserRepository) : IAddSeeLater {
//
//    override fun addSeeLater(movieId: String, userId: String) {
//        val userById = userRepository.getUserById(userId)
//        userById.seeLater.plus(movieId)
//        userRepository.updateUser(userById)
//    }
//}