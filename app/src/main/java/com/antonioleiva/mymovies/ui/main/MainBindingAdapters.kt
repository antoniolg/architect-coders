package com.antonioleiva.mymovies.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.antonioleiva.mymovies.model.database.Movie

@BindingAdapter("items")
fun RecyclerView.setItems(movies: List<Movie>?) {
    (adapter as? MoviesAdapter)?.let {
        it.movies = movies ?: emptyList()
    }
}