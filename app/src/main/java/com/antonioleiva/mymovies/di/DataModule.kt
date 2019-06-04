package com.antonioleiva.mymovies.di

import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.data.repository.PermissionChecker
import com.antonioleiva.data.repository.RegionRepository
import com.antonioleiva.data.source.LocalDataSource
import com.antonioleiva.data.source.LocationDataSource
import com.antonioleiva.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class DataModule {

    @Provides
    fun regionRepositoryProvider(
        locationDataSource: LocationDataSource,
        permissionChecker: PermissionChecker
    ) = RegionRepository(locationDataSource, permissionChecker)

    @Provides
    fun moviesRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
        regionRepository: RegionRepository,
        @Named("apiKey") apiKey: String
    ) = MoviesRepository(localDataSource, remoteDataSource, regionRepository, apiKey)
}