package com.antonioleiva.mymovies

import android.app.Application
import com.antonioleiva.mymovies.di.DaggerMyMoviesComponent
import com.antonioleiva.mymovies.di.MyMoviesComponent

class MoviesApp : Application() {

    lateinit var component: MyMoviesComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerMyMoviesComponent
            .factory()
            .create(this)
    }
}