package com.antonioleiva.mymovies

import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbService {
    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMoviesAsync(@Query("api_key") apiKey: String): MovieDbResult
}