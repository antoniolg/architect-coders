package com.antonioleiva.mymovies.model.server

import com.antonioleiva.data.source.RemoteDataSource
import com.antonioleiva.domain.Movie
import com.antonioleiva.mymovies.model.toDomainMovie

class TheMovieDbDataSource : RemoteDataSource {

    override suspend fun getPopularMovies(apiKey: String, region: String): List<Movie> =
        MovieDb.service
            .listPopularMoviesAsync(apiKey, region)
            .results
            .map { it.toDomainMovie() }
}