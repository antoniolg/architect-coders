package com.antonioleiva.mymovies.di

import android.app.Application
import com.antonioleiva.mymovies.ui.detail.DetailActivityComponent
import com.antonioleiva.mymovies.ui.detail.DetailActivityModule
import com.antonioleiva.mymovies.ui.main.MainActivityComponent
import com.antonioleiva.mymovies.ui.main.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, ServerModule::class])
interface MyMoviesComponent {

    fun plus(module: MainActivityModule): MainActivityComponent
    fun plus(module: DetailActivityModule) : DetailActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): MyMoviesComponent
    }
}