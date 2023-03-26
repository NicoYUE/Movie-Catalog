package com.movies.infrastructure.cassandra

import com.movies.domain.repository.RateRepository
import com.movies.infrastructure.cassandra.entity.RatingByUsernameCassandraEntity
import com.movies.infrastructure.cassandra.imported.ImportedRatingByUsernameCassandraRepository
import org.springframework.stereotype.Repository

@Repository
class RatingByUsernameCassandraRepository(
    val ratingByUsernameCassandraRepository: ImportedRatingByUsernameCassandraRepository
) : RateRepository {

    override fun rate(username: String, title: String, rating: Double) {
        RatingByUsernameCassandraEntity(username, title, rating)
            .let { ratingByUsernameCassandraRepository.save(it) }
    }
}