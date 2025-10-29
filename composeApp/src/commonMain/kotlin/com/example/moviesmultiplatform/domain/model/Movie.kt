package com.example.moviesmultiplatform.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String
)

val movie = Movie(
    id = 1,
    title = "Minecraft",
    overview = "Movie Overview",
    posterUrl = "https://example.com/minecraft.jpg"
)
