package com.antonioleiva.mymovies

import com.antonioleiva.data.repository.PermissionChecker
import com.antonioleiva.data.source.LocalDataSource
import com.antonioleiva.data.source.LocationDataSource
import com.antonioleiva.data.source.RemoteDataSource
import com.antonioleiva.domain.Movie
import com.antonioleiva.mymovies.di.DataModule
import com.antonioleiva.mymovies.di.MyMoviesComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestAppModule::class,
    DataModule::class
])
interface TestComponent: MyMoviesComponent {

    val localDataSource: LocalDataSource
    val remoteDataSource: RemoteDataSource

    @Component.Factory
    interface FactoryTest {
        fun create(): TestComponent
    }
}

@Module
class TestAppModule {

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(): String = ""

    @Provides
    @Singleton
    fun localDataSourceProvider(): LocalDataSource = FakeLocalDataSource()

    @Provides
    @Singleton
    fun remoteDataSourceProvider(): RemoteDataSource = FakeRemoteDataSource()

    @Singleton
    @Provides
    fun locationDataSourceProvider(): LocationDataSource = FakeLocationDataSource()

    @Singleton
    @Provides
    fun permissionCheckerProvider(): PermissionChecker = FakePermissionChecker()

}


class FakeLocalDataSource : LocalDataSource {

    var movies: List<Movie> = emptyList()

    override suspend fun isEmpty() = movies.isEmpty()

    override suspend fun saveMovies(movies: List<Movie>) {
        this.movies = movies
    }

    override suspend fun getPopularMovies(): List<Movie> = movies

    override suspend fun findById(id: Int): Movie = movies.first { it.id == id }

    override suspend fun update(movie: Movie) {
        movies = movies.filterNot { it.id == movie.id } + movie
    }
}

class FakeRemoteDataSource : RemoteDataSource {

    var movies = defaultFakeMovies

    override suspend fun getPopularMovies(apiKey: String, region: String) = movies
}

class FakeLocationDataSource : LocationDataSource {
    var location = "US"

    override suspend fun findLastRegion(): String? = location
}

class FakePermissionChecker : PermissionChecker {
    var permissionGranted = true

    override suspend fun check(permission: PermissionChecker.Permission): Boolean =
            permissionGranted
}

val defaultFakeMovies = listOf(
        mockedMovie.copy(1),
        mockedMovie.copy(2),
        mockedMovie.copy(3),
        mockedMovie.copy(4)
)