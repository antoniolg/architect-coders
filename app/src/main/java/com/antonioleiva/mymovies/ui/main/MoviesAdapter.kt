package com.antonioleiva.mymovies.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.server.Movie
import com.antonioleiva.mymovies.ui.common.basicDiffUtil
import com.antonioleiva.mymovies.ui.common.inflate
import com.antonioleiva.mymovies.ui.common.loadUrl
import kotlinx.android.synthetic.main.view_movie.view.*

class MoviesAdapter(private val listener: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    var movies: List<Movie> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_movie, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { listener(movie) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) {
            itemView.movieTitle.text = movie.title
            itemView.movieCover.loadUrl("https://image.tmdb.org/t/p/w185/${movie.posterPath}")
        }
    }
}