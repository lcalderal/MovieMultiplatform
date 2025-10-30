package com.example.moviesmultiplatform.di

import com.example.moviesmultiplatform.data.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module {
    factory { MoviesRepository(ktorClient = get()) }
}