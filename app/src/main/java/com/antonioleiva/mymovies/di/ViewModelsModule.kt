package com.antonioleiva.mymovies.di

import com.antonioleiva.mymovies.ui.detail.DetailViewModel
import com.antonioleiva.mymovies.ui.main.MainViewModel
import com.antonioleiva.usecases.FindMovieById
import com.antonioleiva.usecases.GetPopularMovies
import com.antonioleiva.usecases.ToggleMovieFavorite
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {

    @Provides
    fun mainViewModelProvider(getPopularMovies: GetPopularMovies) = MainViewModel(getPopularMovies)

    @Provides
    fun detailViewModelProvider(
        findMovieById: FindMovieById,
        toggleMovieFavorite: ToggleMovieFavorite
    ): DetailViewModel {
        // TODO the id needs to be provided. We'll see it with scoped graphs
        return DetailViewModel(-1, findMovieById, toggleMovieFavorite)
    }
}