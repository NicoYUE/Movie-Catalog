package com.movies.domain.model

import lombok.Getter

enum class Genre {

    ACTION,
    ADVENTURE,
    COMEDY,
    DRAMA,
    FANTASY,
    ROMANCE,
    THRILLER,
    SCI_FI,
    WAR;

    companion object {

        @Getter
        private val genresArray = Genre.values()

        // lookup map
        private val genreByValueMap: Map<String, Genre>

        init {
            val initMap = HashMap<String, Genre>()
            genresArray.forEach {
                initMap[it.name.uppercase()] = it
            }
            genreByValueMap = initMap
        }

        fun fromString(value: String): Genre? = genreByValueMap[value.uppercase()]
    }

}

