package com.antonioleiva.data.source

import com.antonioleiva.domain.Movie

interface RemoteDataSource {
    suspend fun getPopularMovies(apiKey: String, region: String): List<Movie>
}