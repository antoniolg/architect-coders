package com.antonioleiva.mymovies.model

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.annotation.SuppressLint
import android.app.Activity
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.location.LocationServices
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine

class RegionRepository(activity: Activity) {

    companion object {
        private const val DEFAULT_REGION = "US"
    }

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
    private val coarsePermissionChecker = PermissionChecker(activity, ACCESS_COARSE_LOCATION)
    private val geocoder = Geocoder(activity)

    suspend fun findLastRegion(): String = findLastLocation().toRegion()

    private suspend fun findLastLocation(): Location? {
        val success = coarsePermissionChecker.request()
        return if (success) lastLocationSuspended() else null
    }

    @SuppressLint("MissingPermission")
    private suspend fun lastLocationSuspended(): Location? =
        suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation
                .addOnCompleteListener {
                    continuation.resume(it.result)
                }
        }

    private fun Location?.toRegion(): String {
        val addresses = this?.let {
            geocoder.getFromLocation(latitude, longitude, 1)
        }
        return addresses?.firstOrNull()?.countryCode ?: DEFAULT_REGION
    }
}