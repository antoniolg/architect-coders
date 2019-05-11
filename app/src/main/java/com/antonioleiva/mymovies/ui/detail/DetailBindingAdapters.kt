package com.antonioleiva.mymovies.ui.detail

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.databinding.BindingAdapter
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.database.Movie
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("movie")
fun TextView.updateMovieDetails(movie: Movie?) = movie?.run {
    text = buildSpannedString {

        bold { append("Original language: ") }
        appendLine(originalLanguage)

        bold { append("Original title: ") }
        appendLine(originalTitle)

        bold { append("Release date: ") }
        appendLine(releaseDate)

        bold { append("Popularity: ") }
        appendLine(popularity.toString())

        bold { append("Vote Average: ") }
        append(voteAverage.toString())
    }
}

@BindingAdapter("favorite")
fun FloatingActionButton.setFavorite(favorite: Boolean?) {
    val icon = if (favorite == true) R.drawable.ic_favorite_on else R.drawable.ic_favorite_off
    setImageDrawable(ContextCompat.getDrawable(context, icon))
}