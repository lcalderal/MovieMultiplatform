package com.example.moviesmultiplatform.features.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviesmultiplatform.data.repository.MoviesRepository
import com.example.moviesmultiplatform.features.components.MoviesSection
import com.example.moviesmultiplatform.features.movies.MoviesListViewModel.MoviesListState

@Composable
fun MoviesListRoute(
    viewModel: MoviesListViewModel = viewModel { MoviesListViewModel(MoviesRepository()) }
) {

    val moviesListState by viewModel.moviesListState.collectAsStateWithLifecycle()

    MoviesListScreen(moviesListState = moviesListState)
}

@Composable
fun MoviesListScreen(moviesListState: MoviesListState) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            when (moviesListState) {
                is MoviesListState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is MoviesListState.Error -> {
                    Text(
                        text = moviesListState.message,
                        modifier = Modifier.padding(16.dp).align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }

                is MoviesListState.Success -> {
                    LazyColumn(
                        modifier = Modifier,
                        contentPadding = PaddingValues(vertical = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        items(moviesListState.movieSections) { movieSection ->
                            MoviesSection(
                                title = movieSection.sectionType.title,
                                movies = movieSection.movies
                            )
                        }
                    }
                }
            }
        }
    }
}