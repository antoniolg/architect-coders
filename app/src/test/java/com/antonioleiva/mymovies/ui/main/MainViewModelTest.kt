package com.antonioleiva.mymovies.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.antonioleiva.mymovies.testshared.mockedMovie
import com.antonioleiva.mymovies.ui.main.MainViewModel.UiModel
import com.antonioleiva.usecases.GetPopularMovies
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
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var getPopularMovies: GetPopularMovies

    @Mock
    lateinit var observer: Observer<UiModel>

    private lateinit var vm: MainViewModel

    @Before
    fun setUp() {
        vm = MainViewModel(getPopularMovies, Dispatchers.Unconfined)
    }

    @Test
    fun `observing LiveData launches location permission request`() {

        vm.model.observeForever(observer)

        verify(observer).onChanged(UiModel.RequestLocationPermission)
    }

    @Test
    fun `after requesting the permission, loading is shown`() {
        runBlocking {

            val movies = listOf(mockedMovie.copy(id = 1))
            whenever(getPopularMovies.invoke()).thenReturn(movies)
            vm.model.observeForever(observer)

            vm.onCoarsePermissionRequested()

            verify(observer).onChanged(UiModel.Loading)
        }
    }

    @Test
    fun `after requesting the permission, getPopularMovies is called`() {

        runBlocking {
            val movies = listOf(mockedMovie.copy(id = 1))
            whenever(getPopularMovies.invoke()).thenReturn(movies)

            vm.model.observeForever(observer)

            vm.onCoarsePermissionRequested()

            verify(observer).onChanged(UiModel.Content(movies))
        }
    }
}