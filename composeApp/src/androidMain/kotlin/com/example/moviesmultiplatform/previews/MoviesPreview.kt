package com.example.moviesmultiplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesmultiplatform.domain.model.MovieSection
import com.example.moviesmultiplatform.domain.model.movie
import com.example.moviesmultiplatform.features.components.MoviePoster
import com.example.moviesmultiplatform.features.movies.MoviesListScreen
import com.example.moviesmultiplatform.features.movies.MoviesListViewModel

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(movie = movie)
}

@Preview(showBackground = true)
@Composable
private fun MoviesListScreenPreview() {
    MoviesListScreen(
        moviesListState = MoviesListViewModel.MoviesListState.Success(
            movieSections = listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = listOf(movie)
                )
            )
        )
    )
}