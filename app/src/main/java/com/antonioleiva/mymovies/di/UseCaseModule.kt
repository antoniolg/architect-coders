package com.antonioleiva.mymovies.di

import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.usecases.FindMovieById
import com.antonioleiva.usecases.GetPopularMovies
import com.antonioleiva.usecases.ToggleMovieFavorite
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun getPopularMoviesProvider(moviesRepository: MoviesRepository) =
        GetPopularMovies(moviesRepository)

    @Provides
    fun findMovieByIdProvider(moviesRepository: MoviesRepository) = FindMovieById(moviesRepository)

    @Provides
    fun toggleMovieFavoriteProvider(moviesRepository: MoviesRepository) =
        ToggleMovieFavorite(moviesRepository)
}