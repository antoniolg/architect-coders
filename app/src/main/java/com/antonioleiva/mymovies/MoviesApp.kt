package com.antonioleiva.mymovies

import android.app.Application
import com.antonioleiva.mymovies.di.DaggerMyMoviesComponent
import com.antonioleiva.mymovies.di.MyMoviesComponent

open class MoviesApp : Application() {

    lateinit var component: MyMoviesComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = initMoviesComponent()
    }

    open fun initMoviesComponent() = DaggerMyMoviesComponent.factory().create(this)
}