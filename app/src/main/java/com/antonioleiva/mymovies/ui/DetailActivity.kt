package com.antonioleiva.mymovies.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.antonioleiva.mymovies.databinding.ActivityDetailBinding
import com.antonioleiva.mymovies.model.Movie

class DetailActivity : AppCompatActivity() {

    companion object {
        const val MOVIE = "DetailActivity:movie"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityDetailBinding.inflate(layoutInflater).run {
            setContentView(root)

            val movie = intent.getParcelableExtra<Movie>(MOVIE) ?: throw IllegalStateException()

            movieDetailToolbar.title = movie.title

            val background = movie.backdropPath ?: movie.posterPath
            movieDetailImage.loadUrl("https://image.tmdb.org/t/p/w780$background")
            movieDetailSummary.text = movie.overview
            movieDetailInfo.setMovie(movie)
        }
    }
}