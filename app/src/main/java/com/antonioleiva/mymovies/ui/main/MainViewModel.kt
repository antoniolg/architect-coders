package com.antonioleiva.mymovies.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.antonioleiva.mymovies.model.database.Movie
import com.antonioleiva.mymovies.model.server.MoviesRepository
import com.antonioleiva.mymovies.ui.common.ScopedViewModel
import kotlinx.coroutines.launch

class MainViewModel(private val moviesRepository: MoviesRepository) : ScopedViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val movies: List<Movie>) : UiModel()
        class Navigation(val movie: Movie) : UiModel()
        object RequestLocationPermission : UiModel()
    }

    init {
        initScope()
    }

    private fun refresh() {
        _model.value = UiModel.RequestLocationPermission
    }

    fun onCoarsePermissionRequested() {
        launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(moviesRepository.findPopularMovies())
        }
    }

    fun onMovieClicked(movie: Movie) {
        _model.value = UiModel.Navigation(movie)
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}