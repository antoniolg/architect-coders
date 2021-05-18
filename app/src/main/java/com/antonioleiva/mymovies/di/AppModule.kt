package com.antonioleiva.mymovies.di

import android.app.Application
import androidx.room.Room
import com.antonioleiva.data.repository.PermissionChecker
import com.antonioleiva.data.source.LocalDataSource
import com.antonioleiva.data.source.LocationDataSource
import com.antonioleiva.data.source.RemoteDataSource
import com.antonioleiva.mymovies.R
import com.antonioleiva.mymovies.data.AndroidPermissionChecker
import com.antonioleiva.mymovies.data.PlayServicesLocationDataSource
import com.antonioleiva.mymovies.data.database.MovieDatabase
import com.antonioleiva.mymovies.data.database.RoomDataSource
import com.antonioleiva.mymovies.data.server.TheMovieDbDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(app: Application): String = app.getString(R.string.api_key)

    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        MovieDatabase::class.java,
        "movie-db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: MovieDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = TheMovieDbDataSource()

    @Provides
    fun locationDataSourceProvider(app: Application): LocationDataSource =
        PlayServicesLocationDataSource(app)

    @Provides
    fun permissionCheckerProvider(app: Application): PermissionChecker =
        AndroidPermissionChecker(app)
}