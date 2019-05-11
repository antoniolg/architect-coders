package com.antonioleiva.mymovies.ui.main

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.antonioleiva.mymovies.PermissionRequester
import com.antonioleiva.mymovies.databinding.ActivityMainBinding
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.model.server.MoviesRepository
import com.antonioleiva.mymovies.ui.common.EventObserver
import com.antonioleiva.mymovies.ui.common.app
import com.antonioleiva.mymovies.ui.common.getViewModel
import com.antonioleiva.mymovies.ui.common.startActivity
import com.antonioleiva.mymovies.ui.detail.DetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MoviesAdapter
    private val coarsePermissionRequester = PermissionRequester(this, ACCESS_COARSE_LOCATION)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getViewModel { MainViewModel(MoviesRepository(app)) }

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        adapter = MoviesAdapter(viewModel::onMovieClicked)
        binding.recycler.adapter = adapter

        viewModel.navigateToMovie.observe(this, EventObserver { id ->
            startActivity<DetailActivity> {
                putExtra(DetailActivity.MOVIE, id)
            }
        })

        viewModel.requestLocationPermission.observe(this, EventObserver {
            coarsePermissionRequester.request {
                viewModel.onCoarsePermissionRequested()
            }
        })
    }
}