package com.antonioleiva.mymovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.MovieDb
import com.antonioleiva.mymovies.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val adapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

        GlobalScope.launch(Dispatchers.Main) {
            val movies = MovieDb.service.listPopularMoviesAsync(getString(
                R.string.api_key
            ))
            adapter.movies = movies.results
        }
    }
}
