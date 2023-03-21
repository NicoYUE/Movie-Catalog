package com.movies.domain.model

import lombok.Getter

enum class Genre {

    ACTION,
    ADVENTURE,
    COMEDY,
    CRIME,
    DRAMA,
    FANTASY,
    HISTORY,
    ROMANCE,
    THRILLER,
    SCI_FI,
    WAR;

    companion object {

        @Getter
        private val genresArray = Genre.values()

        // lookup map
        private val genreByValueMap: Map<String, Genre>

        private val nonAlphaNumericRegex = Regex("[^A-Za-z0-9]")

        init {
            val initMap = HashMap<String, Genre>()
            genresArray.forEach {
                val cleanedUpName = it.name.replace(nonAlphaNumericRegex, "")
                initMap[cleanedUpName.uppercase()] = it
            }
            genreByValueMap = initMap
        }

        fun fromString(value: String): Genre? {
            val cleanedUpValue = value.replace(nonAlphaNumericRegex, "")
            return genreByValueMap[cleanedUpValue.uppercase()]
        }
    }

}

