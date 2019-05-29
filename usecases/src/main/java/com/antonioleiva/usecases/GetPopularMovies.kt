package com.antonioleiva.usecases

import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.domain.Movie

class GetPopularMovies(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(): List<Movie> = moviesRepository.getPopularMovies()
}