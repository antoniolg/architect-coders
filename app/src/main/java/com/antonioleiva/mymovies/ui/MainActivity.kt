package com.antonioleiva.mymovies.ui

import android.Manifest
import android.annotation.SuppressLint
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.databinding.ActivityMainBinding
import com.antonioleiva.mymovies.model.MovieDb
import com.antonioleiva.mymovies.ui.common.CoroutineScopeActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.single.BasePermissionListener
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class MainActivity : CoroutineScopeActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val adapter = MoviesAdapter {
        startActivity<DetailActivity> {
            putExtra(DetailActivity.MOVIE, it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        launch {
            val location = getLocation()
            val movies = MovieDb.service
                .listPopularMoviesAsync(
                    getString(R.string.api_key),
                    getRegionFromLocation(location)
                )

            adapter.movies = movies.results
        }

        binding.recycler.adapter = adapter
    }

    private suspend fun getLocation(): Location? {
        val success = requestCoarseLocationPermission()
        return if (success) findLastLocation() else null
    }

    @SuppressLint("MissingPermission")
    private suspend fun findLastLocation(): Location? =
        suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation
                .addOnCompleteListener {
                    continuation.resume(it.result)
                }
        }

    private suspend fun requestCoarseLocationPermission(): Boolean =
        suspendCancellableCoroutine { continuation ->
            Dexter
                .withContext(this@MainActivity)
                .withPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(object : BasePermissionListener() {
                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                        continuation.resume(true)
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                        continuation.resume(false)
                    }
                }
                ).check()
        }

    private fun getRegionFromLocation(location: Location?): String {
        val geocoder = Geocoder(this@MainActivity)
        val fromLocation = location?.let {
            geocoder.getFromLocation(
                location.latitude,
                location.longitude,
                1
            )
        }
        return fromLocation?.firstOrNull()?.countryCode ?: "US"
    }
}
