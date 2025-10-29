package com.example.moviesmultiplatform.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesmultiplatform.domain.model.movie
import com.example.moviesmultiplatform.features.components.MoviePoster
import com.example.moviesmultiplatform.features.movies.MoviesListScreen

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(movie = movie)
}

@Preview(showBackground = true)
@Composable
private fun MoviesListScreenPreview() {
    MoviesListScreen(listOf(movie))
}