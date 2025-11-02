package com.example.moviesmultiplatform

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesmultiplatform.di.dataModule
import com.example.moviesmultiplatform.di.networkModule
import com.example.moviesmultiplatform.di.viewModelModule
import com.example.moviesmultiplatform.features.movies.MoviesListRoute
import com.example.moviesmultiplatform.features.theme.MoviesAppTheme
import com.example.moviesmultiplatform.navigation.AppRoutes
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(networkModule, dataModule, viewModelModule)
        }
    ) {
        MoviesAppTheme {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = AppRoutes.MoviesList
            ) {
                composable<AppRoutes.MoviesList> {
                    MoviesListRoute()
                }

                composable<AppRoutes.MovieDetails> {
                    // MovieDetailsScreen
                }
            }
        }
    }
}