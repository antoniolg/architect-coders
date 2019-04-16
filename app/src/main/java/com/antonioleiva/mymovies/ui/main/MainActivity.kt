package com.antonioleiva.mymovies.ui.main

import android.os.Bundle
import android.view.View
import com.antonioleiva.mymovies.databinding.ActivityMainBinding
import com.antonioleiva.mymovies.model.MoviesRepository
import com.antonioleiva.mymovies.ui.common.CoroutineScopeActivity
import com.antonioleiva.mymovies.ui.common.startActivity
import com.antonioleiva.mymovies.ui.detail.DetailActivity
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
        with(ActivityMainBinding.inflate(layoutInflater)) {
            setContentView(root)

            recycler.adapter = adapter

            launch {
                progress.visibility = View.VISIBLE
                adapter.movies = moviesRepository.findPopularMovies().results
                progress.visibility = View.GONE
            }
        }
    }
}