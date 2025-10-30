package com.example.moviesmultiplatform.domain.model

import com.example.moviesmultiplatform.data.model.MovieResponse
import com.example.moviesmultiplatform.data.network.IMAGE_SMALL_BASE_URL

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String
)

fun MovieResponse.toModel(): Movie {
    return Movie(
        id = this.id,
        title = this.title,
        overview = this.overview,
        posterUrl = "${IMAGE_SMALL_BASE_URL}${this.posterPath}"
    )
}

val movie = Movie(
    id = 1,
    title = "Minecraft",
    overview = "Movie Overview",
    posterUrl = "https://example.com/minecraft.jpg"
)
