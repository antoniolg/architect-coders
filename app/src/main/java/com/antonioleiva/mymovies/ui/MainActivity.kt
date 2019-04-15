package com.antonioleiva.mymovies.ui

import android.os.Bundle
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.MoviesRepository
import com.antonioleiva.mymovies.ui.common.CoroutineScopeActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : CoroutineScopeActivity() {

    private val moviesRepository: MoviesRepository by lazy { MoviesRepository(this) }

    private val adapter = MoviesAdapter {
        startActivity<DetailActivity> {
            putExtra(DetailActivity.MOVIE, it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.adapter = adapter

        launch {
            adapter.movies = moviesRepository.findPopularMovies().results
        }
    }
}