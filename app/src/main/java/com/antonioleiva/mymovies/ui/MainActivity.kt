package com.antonioleiva.mymovies.ui

import android.os.Bundle
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.MovieDb
import com.antonioleiva.mymovies.ui.common.CoroutineScopeActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : CoroutineScopeActivity() {

    private val adapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.adapter = adapter

        launch {
            val movies = MovieDb.service
                .listPopularMoviesAsync(getString(R.string.api_key))
            adapter.movies = movies.results
        }
    }
}
