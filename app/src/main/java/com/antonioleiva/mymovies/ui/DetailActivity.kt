package com.antonioleiva.mymovies.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.antonioleiva.mymovies.databinding.ActivityDetailBinding
import com.antonioleiva.mymovies.model.Movie

class DetailActivity : AppCompatActivity() {

    companion object {
        const val MOVIE = "DetailActivity:movie"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getParcelableExtra<Movie>(MOVIE)?.run {
            binding.movieDetailToolbar.title = title

            val background = backdropPath ?: posterPath
            binding.movieDetailImage.loadUrl("https://image.tmdb.org/t/p/w780$background")

            binding.movieDetailSummary.text = overview

            binding.movieDetailInfo.text = buildSpannedString {

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
    }
}
