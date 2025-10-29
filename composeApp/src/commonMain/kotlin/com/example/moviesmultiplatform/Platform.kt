package com.example.moviesmultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform