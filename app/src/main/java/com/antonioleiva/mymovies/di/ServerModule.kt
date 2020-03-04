package com.antonioleiva.mymovies.di

import com.antonioleiva.mymovies.data.server.TheMovieDb
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ServerModule {

    @Singleton
    @Provides
    @Named("baseUrl")
    fun baseUrlProvider() = "https://api.themoviedb.org/3/"

    @Singleton
    @Provides
    fun movieDBProvider(@Named("baseUrl") baseUrl: String) = TheMovieDb(baseUrl)

}