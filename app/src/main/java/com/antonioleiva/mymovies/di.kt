package com.antonioleiva.mymovies

import android.app.Application
import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.data.repository.PermissionChecker
import com.antonioleiva.data.repository.RegionRepository
import com.antonioleiva.data.source.LocalDataSource
import com.antonioleiva.data.source.LocationDataSource
import com.antonioleiva.data.source.RemoteDataSource
import com.antonioleiva.mymovies.data.AndroidPermissionChecker
import com.antonioleiva.mymovies.data.PlayServicesLocationDataSource
import com.antonioleiva.mymovies.data.database.MovieDatabase
import com.antonioleiva.mymovies.data.database.RoomDataSource
import com.antonioleiva.mymovies.data.server.TheMovieDbDataSource
import com.antonioleiva.mymovies.ui.detail.DetailActivity
import com.antonioleiva.mymovies.ui.detail.DetailViewModel
import com.antonioleiva.mymovies.ui.main.MainActivity
import com.antonioleiva.mymovies.ui.main.MainViewModel
import com.antonioleiva.usecases.FindMovieById
import com.antonioleiva.usecases.GetPopularMovies
import com.antonioleiva.usecases.ToggleMovieFavorite
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    single(named("apiKey")) { androidApplication().getString(R.string.api_key) }
    single { MovieDatabase.build(get()) }
    factory<LocalDataSource> { RoomDataSource(get()) }
    factory<RemoteDataSource> { TheMovieDbDataSource() }
    factory<LocationDataSource> { PlayServicesLocationDataSource(get()) }
    factory<PermissionChecker> { AndroidPermissionChecker(get()) }
    single<CoroutineDispatcher> { Dispatchers.Main }
}

private val dataModule = module {
    factory { RegionRepository(get(), get()) }
    factory { MoviesRepository(get(), get(), get(), get(named("apiKey"))) }
}

private val scopesModule = module {
    scope(named<MainActivity>()) {
        viewModel { MainViewModel(get(), get()) }
        scoped { GetPopularMovies(get()) }
    }

    scope(named<DetailActivity>()) {
        viewModel { (id: Int) -> DetailViewModel(id, get(), get(), get()) }
        scoped { FindMovieById(get()) }
        scoped { ToggleMovieFavorite(get()) }
    }
}