package com.antonioleiva.mymovies.model.server

import com.antonioleiva.mymovies.MoviesApp
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.RegionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.antonioleiva.mymovies.model.database.Movie as DbMovie
import com.antonioleiva.mymovies.model.server.Movie as ServerMovie

class MoviesRepository(application: MoviesApp) {

    private val apiKey = application.getString(R.string.api_key)
    private val regionRepository = RegionRepository(application)
    private val db = application.db

    suspend fun findPopularMovies(): List<DbMovie> = withContext(Dispatchers.IO) {

        with(db.movieDao()) {
            if (movieCount() <= 0) {

                val movies = MovieDb.service
                    .listPopularMoviesAsync(apiKey, regionRepository.findLastRegion())
                    .results

                insertMovies(movies.map(ServerMovie::convertToDbMovie))
            }

            getAll()
        }
    }

    suspend fun findById(id: Int): DbMovie = withContext(Dispatchers.IO) {
        db.movieDao().findById(id)
    }

    suspend fun update(movie: DbMovie) = withContext(Dispatchers.IO) {
        db.movieDao().updateMovie(movie)
    }
}

private fun ServerMovie.convertToDbMovie() = DbMovie(
    0,
    title,
    overview,
    releaseDate,
    "https://image.tmdb.org/t/p/w185/$posterPath",
    "https://image.tmdb.org/t/p/w780${backdropPath ?: posterPath}",
    originalLanguage,
    originalTitle,
    popularity,
    voteAverage,
    false
)