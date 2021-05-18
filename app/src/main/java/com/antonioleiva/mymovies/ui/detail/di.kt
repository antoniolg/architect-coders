package com.antonioleiva.mymovies.ui.detail

import androidx.lifecycle.SavedStateHandle
import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.usecases.FindMovieById
import com.antonioleiva.usecases.GetPopularMovies
import com.antonioleiva.usecases.ToggleMovieFavorite
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import java.lang.IllegalStateException
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
class DetailActivityModule {

    @Provides
    fun findMovieByIdProvider(moviesRepository: MoviesRepository) = FindMovieById(moviesRepository)

    @Provides
    fun toggleMovieFavoriteProvider(moviesRepository: MoviesRepository) =
        ToggleMovieFavorite(moviesRepository)

    @Provides
    @Named("movieId")
    fun movieIdProvider(stateHandle: SavedStateHandle): Int =
        stateHandle.get<Int>(DetailActivity.MOVIE)
            ?: throw IllegalStateException("Movie Id not found in the state handle")
}