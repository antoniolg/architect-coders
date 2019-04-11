package com.antonioleiva.mymovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.MovieDb
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val adapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.adapter = adapter

        GlobalScope.launch(Dispatchers.Main) {
            val movies = MovieDb.service.listPopularMoviesAsync(getString(
                R.string.api_key
            ))
            adapter.movies = movies.results
        }
    }
}
