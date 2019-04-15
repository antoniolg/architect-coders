package com.antonioleiva.mymovies.model

import android.app.Activity
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.single.BasePermissionListener
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine

class PermissionChecker(private val activity: Activity, private val permission: String) {

    suspend fun request(): Boolean =
        suspendCancellableCoroutine { continuation ->
            Dexter
                .withActivity(activity)
                .withPermission(permission)
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
}