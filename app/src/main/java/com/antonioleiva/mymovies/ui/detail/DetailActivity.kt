package com.antonioleiva.mymovies.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.data.repository.RegionRepository
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.data.AndroidPermissionChecker
import com.antonioleiva.mymovies.data.PlayServicesLocationDataSource
import com.antonioleiva.mymovies.data.database.RoomDataSource
import com.antonioleiva.mymovies.data.server.TheMovieDbDataSource
import com.antonioleiva.mymovies.ui.common.app
import com.antonioleiva.mymovies.ui.common.getViewModel
import com.antonioleiva.mymovies.ui.common.loadUrl
import com.antonioleiva.usecases.FindMovieById
import com.antonioleiva.usecases.ToggleMovieFavorite
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

        viewModel = getViewModel {
            val moviesRepository = MoviesRepository(
                RoomDataSource(app.db),
                TheMovieDbDataSource(),
                RegionRepository(
                    PlayServicesLocationDataSource(app),
                    AndroidPermissionChecker(app)
                ),
                app.getString(R.string.api_key)
            )

            DetailViewModel(
                intent.getIntExtra(MOVIE, -1),
                FindMovieById(moviesRepository),
                ToggleMovieFavorite(moviesRepository)
            )
        }

        viewModel.model.observe(this, Observer(::updateUi))

        movieDetailFavorite.setOnClickListener { viewModel.onFavoriteClicked() }
    }

    private fun updateUi(model: DetailViewModel.UiModel) = with(model.movie) {
        movieDetailToolbar.title = title
        movieDetailImage.loadUrl("https://image.tmdb.org/t/p/w780$backdropPath")
        movieDetailSummary.text = overview
        movieDetailInfo.setMovie(this)

        val icon = if (favorite) R.drawable.ic_favorite_on else R.drawable.ic_favorite_off
        movieDetailFavorite.setImageDrawable(getDrawable(icon))
    }
}
