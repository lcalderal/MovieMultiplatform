package com.example.moviesmultiplatform

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesmultiplatform.navigation.AppRoutes
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = AppRoutes.MoviesList
        ) {
            composable<AppRoutes.MoviesList> {
                // MovieListScreen()
            }

            composable<AppRoutes.MovieDetails> {
                // MovieDetailsScreen
            }
        }
    }
}