package com.antonioleiva.mymovies.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.antonioleiva.mymovies.testshared.mockedMovie
import com.antonioleiva.usecases.FindMovieById
import com.antonioleiva.usecases.ToggleMovieFavorite
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var findMovieById: FindMovieById

    @Mock
    lateinit var toggleMovieFavorite: ToggleMovieFavorite

    @Mock
    lateinit var observer: Observer<DetailViewModel.UiModel>

    private lateinit var vm: DetailViewModel

    @Before
    fun setUp() {
        vm = DetailViewModel(1, findMovieById, toggleMovieFavorite, Dispatchers.Unconfined)
    }

    @Test
    fun `observing LiveData finds the movie`() {

        runBlocking {
            val movie = mockedMovie.copy(id = 1)
            whenever(findMovieById.invoke(1)).thenReturn(movie)

            vm.model.observeForever(observer)

            verify(observer).onChanged(DetailViewModel.UiModel(movie))
        }
    }

    @Test
    fun `when favorite clicked, the toggleMovieFavorite use case is invoked`() {
        runBlocking {
            val movie = mockedMovie.copy(id = 1)
            whenever(findMovieById.invoke(1)).thenReturn(movie)
            whenever(toggleMovieFavorite.invoke(movie)).thenReturn(movie.copy(favorite = !movie.favorite))
            vm.model.observeForever(observer)

            vm.onFavoriteClicked()

            verify(toggleMovieFavorite).invoke(movie)
        }
    }
}