package com.antonioleiva.mymovies.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.antonioleiva.mymovies.model.database.Movie
import com.antonioleiva.mymovies.model.server.MoviesRepository
import com.antonioleiva.mymovies.ui.common.ScopedViewModel
import kotlinx.coroutines.launch

class DetailViewModel(private val movieId: Int, private val moviesRepository: MoviesRepository) :
    ScopedViewModel() {

    class UiModel(val movie: Movie)

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) findMovie()
            return _model
        }

    private fun findMovie() {
        launch {
            _model.value = UiModel(moviesRepository.findById(movieId))
        }
    }
}