package com.antonioleiva.usecases

import com.antonioleiva.data.repository.MoviesRepository
import com.antonioleiva.mymovies.testshared.mockedMovie
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FindMovieByIdTest {

    @Mock
    lateinit var moviesRepository: MoviesRepository

    lateinit var findMovieById: FindMovieById

    @Before
    fun setUp() {
        findMovieById = FindMovieById(moviesRepository)
    }

    @Test
    fun `invoke calls movies repository`() {
        runBlocking {

            val movie = mockedMovie.copy(id = 1)
            whenever(moviesRepository.findById(1)).thenReturn(movie)

            val result = findMovieById.invoke(1)

            assertEquals(movie, result)
        }
    }
}