package com.antonioleiva.mymovies.di

import android.app.Application
import com.antonioleiva.mymovies.ui.detail.DetailViewModel
import com.antonioleiva.mymovies.ui.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, UseCaseModule::class, ViewModelsModule::class])
interface MyMoviesComponent {

    val mainViewModel: MainViewModel
    val detaiViewModel: DetailViewModel

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): MyMoviesComponent
    }
}