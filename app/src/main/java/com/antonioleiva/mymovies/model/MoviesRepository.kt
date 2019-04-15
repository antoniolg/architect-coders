package com.antonioleiva.mymovies.model

import android.app.Activity
import com.antonioleiva.mymovies.R

class MoviesRepository(activity: Activity) {

    private val apiKey = activity.getString(R.string.api_key)
    private val regionRepository = RegionRepository(activity)

    suspend fun findPopularMovies() =
        MovieDb.service
            .listPopularMoviesAsync(
                apiKey,
                regionRepository.findLastRegion()
            )
}