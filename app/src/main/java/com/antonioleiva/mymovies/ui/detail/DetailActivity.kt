package com.antonioleiva.mymovies.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.Movie
import com.antonioleiva.mymovies.ui.common.loadUrl
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val MOVIE = "DetailActivity:movie"
    }

    private lateinit var viewModel: DetailViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie: Movie = intent.getParcelableExtra(MOVIE)
            ?: throw (IllegalStateException("Movie not found"))

        viewModel = ViewModelProvider(
            this,
            DetailViewModelFactory(movie)
        ).get()

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: DetailViewModel.UiModel) = with(model.movie) {
        movieDetailToolbar.title = title
        movieDetailImage.loadUrl("https://image.tmdb.org/t/p/w780$backdropPath")
        movieDetailSummary.text = overview
        movieDetailInfo.setMovie(this)
    }
}
