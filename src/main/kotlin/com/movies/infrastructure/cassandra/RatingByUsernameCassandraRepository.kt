package com.movies.infrastructure.cassandra

import com.movies.application.dto.Rating
import com.movies.domain.repository.CatalogRepository
import com.movies.infrastructure.cassandra.entity.RatingByUsernameCassandraEntity
import com.movies.infrastructure.cassandra.imported.ImportedRatingByUsernameCassandraRepository
import org.springframework.stereotype.Repository

@Repository
class RatingByUsernameCassandraRepository(
    val ratingByUsernameCassandraRepository: ImportedRatingByUsernameCassandraRepository
) : CatalogRepository {

    override fun rate(username: String, title: String, rating: Double) {
        RatingByUsernameCassandraEntity(username, title, rating)
            .let { ratingByUsernameCassandraRepository.save(it) }
    }
}