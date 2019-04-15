package com.antonioleiva.mymovies.ui

import android.os.Bundle
import com.antonioleiva.mymovies.databinding.ActivityMainBinding
import com.antonioleiva.mymovies.model.MoviesRepository
import com.antonioleiva.mymovies.ui.common.CoroutineScopeActivity
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
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

        launch {
            adapter.movies = moviesRepository.findPopularMovies().results
        }
    }
}