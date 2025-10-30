package com.example.moviesmultiplatform.di

import com.example.moviesmultiplatform.features.movies.MoviesListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MoviesListViewModel(get()) }
}