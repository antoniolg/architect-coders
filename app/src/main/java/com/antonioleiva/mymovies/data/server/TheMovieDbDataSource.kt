package com.antonioleiva.mymovies.data.server

import com.antonioleiva.data.source.RemoteDataSource
import com.antonioleiva.domain.Movie
import com.antonioleiva.mymovies.data.toDomainMovie

class TheMovieDbDataSource(private val theMovieDB: TheMovieDb) : RemoteDataSource {

    override suspend fun getPopularMovies(apiKey: String, region: String): List<Movie> =
            theMovieDB.service
                    .listPopularMoviesAsync(apiKey, region)
                    .results
                    .map { it.toDomainMovie() }
}