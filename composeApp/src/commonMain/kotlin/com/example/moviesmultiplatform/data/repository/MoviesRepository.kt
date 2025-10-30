package com.example.moviesmultiplatform.data.repository

import com.example.moviesmultiplatform.data.network.KtorClient
import com.example.moviesmultiplatform.domain.model.MovieSection
import com.example.moviesmultiplatform.domain.model.toModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MoviesRepository(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getMovieSections(): List<MovieSection> {
        return withContext(ioDispatcher) {
            val popularMoviesDeferred = async { KtorClient.getMovies("popular") }
            val topRatedMoviesDeferred = async { KtorClient.getMovies("top_rated") }
            val upcomingMoviesDeferred = async { KtorClient.getMovies("upcoming") }

            val popularMovies = popularMoviesDeferred.await()
            val topRatedMovies = topRatedMoviesDeferred.await()
            val upcomingMovies = upcomingMoviesDeferred.await()

            listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = popularMovies.results.map { it.toModel() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.TOP_RATED,
                    movies = topRatedMovies.results.map { it.toModel() }
                ),
                MovieSection(
                    sectionType = MovieSection.SectionType.UPCOMING,
                    movies = upcomingMovies.results.map { it.toModel() }
                )
            )
        }
    }
}