package com.antonioleiva.usecases

import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.mymovies.testshared.mockedMovie
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetPopularMoviesTest {

    @Mock
    lateinit var moviesRepository: MoviesRepository

    lateinit var getPopularMovies: GetPopularMovies

    @Before
    fun setUp() {
        getPopularMovies = GetPopularMovies(moviesRepository)
    }

    @Test
    fun `invoke calls movies repository`() {
        runBlocking {

            val movies = listOf(mockedMovie.copy(id = 1))
            whenever(moviesRepository.getPopularMovies()).thenReturn(movies)

            val result = getPopularMovies.invoke()

            Assert.assertEquals(movies, result)
        }
    }
}