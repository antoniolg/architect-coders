package com.antonioleiva.mymovies.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.databinding.ActivityDetailBinding
import com.antonioleiva.mymovies.model.server.MoviesRepository
import com.antonioleiva.mymovies.ui.common.app
import com.antonioleiva.mymovies.ui.common.getViewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val MOVIE = "DetailActivity:movie"
    }

    private lateinit var viewModel: DetailViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getViewModel {
            DetailViewModel(intent.getIntExtra(MOVIE, -1), MoviesRepository(app))
        }

        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }
}