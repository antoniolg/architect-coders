package com.antonioleiva.mymovies

import android.app.Application
import com.antonioleiva.mymovies.data.server.TheMovieDb
import com.antonioleiva.mymovies.di.AppModule
import com.antonioleiva.mymovies.di.DataModule
import com.antonioleiva.mymovies.di.MyMoviesComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.mockwebserver.MockWebServer
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, TestServerModule::class])
interface UiTestComponent: MyMoviesComponent {

    val movieDB: TheMovieDb
    val mockWebServer: MockWebServer

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): UiTestComponent
    }
}

@Module
class TestServerModule {

    @Singleton
    @Provides
    @Named("baseUrl")
    fun baseUrlProvider() = "http://127.0.0.1:8080"

    @Provides
    @Singleton
    fun mockWebServerProvider(): MockWebServer {
        var mockWebServer:MockWebServer? = null
        val thread = Thread(Runnable {
            mockWebServer = MockWebServer()
            mockWebServer?.start(8080)
        })
        thread.start()
        thread.join()
        return mockWebServer ?: throw NullPointerException()
    }

    @Provides
    @Singleton
    fun lolServiceManagerProvider(
            @Named("baseUrl") baseUrl: String
    ): TheMovieDb
            = TheMovieDb(baseUrl)

}
