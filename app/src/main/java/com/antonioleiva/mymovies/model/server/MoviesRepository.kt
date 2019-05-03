package com.antonioleiva.mymovies.model.server

import android.app.Application
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.RegionRepository

class MoviesRepository(application: Application) {

    private val apiKey = application.getString(R.string.api_key)
    private val regionRepository = RegionRepository(application)

    suspend fun findPopularMovies() =
        MovieDb.service
            .listPopularMoviesAsync(
                apiKey,
                regionRepository.findLastRegion()
            )
}