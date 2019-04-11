package com.antonioleiva.mymovies.ui

import android.os.Bundle
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.databinding.ActivityMainBinding
import com.antonioleiva.mymovies.model.MovieDb
import com.antonioleiva.mymovies.ui.common.CoroutineScopeActivity
import kotlinx.coroutines.launch

class MainActivity : CoroutineScopeActivity() {

    private val adapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

        launch {
            val movies = MovieDb.service
                .listPopularMoviesAsync(getString(R.string.api_key))
            adapter.movies = movies.results
        }
    }
}
