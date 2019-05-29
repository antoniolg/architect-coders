package com.antonioleiva.usecases

import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.domain.Movie

class ToggleMovieFavorite(private val moviesRepository: MoviesRepository) {
    suspend fun invoke(movie: Movie): Movie = with(movie) {
        copy(favorite = !favorite).also { moviesRepository.update(it) }
    }
}