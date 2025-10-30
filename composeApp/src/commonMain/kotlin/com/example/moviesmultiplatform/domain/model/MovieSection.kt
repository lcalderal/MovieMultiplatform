package com.example.moviesmultiplatform.domain.model

data class MovieSection(
    val sectionType: SectionType,
    val movies: List<Movie>
) {
    enum class SectionType(val title: String) {
        POPULAR("Popular Movies"),
        TOP_RATED("Top Rated Movies"),
        UPCOMING("Upcoming Movies")
    }
}
