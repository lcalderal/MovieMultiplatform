package com.example.moviesmultiplatform.di

import com.example.moviesmultiplatform.data.network.KtorClient
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }

}