package com.antonioleiva.mymovies.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.Movie
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val MOVIE = "DetailActivity:movie"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent.getParcelableExtra<Movie>(MOVIE)?.run {
            movieDetailToolbar.title = title

            val background = backdropPath ?: posterPath
            movieDetailImage.loadUrl("https://image.tmdb.org/t/p/w780$background")

            movieDetailSummary.text = overview

            movieDetailInfo.text = buildSpannedString {

                bold { append("Original language: ") }
                appendln(originalLanguage)

                bold { append("Original title: ") }
                appendln(originalTitle)

                bold { append("Release date: ") }
                appendln(releaseDate)

                bold { append("Popularity: ") }
                appendln(popularity.toString())

                bold { append("Vote Average: ") }
                append(voteAverage.toString())
            }
        }
    }
}
