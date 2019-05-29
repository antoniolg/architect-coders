package com.antonioleiva.usecases

import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.domain.Movie

class FindMovieById(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(id: Int): Movie = moviesRepository.findById(id)
}