package com.antonioleiva.mymovies.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.antonioleiva.mymovies.*
import com.antonioleiva.mymovies.ui.main.MainActivityModule
import com.antonioleiva.mymovies.ui.main.MainViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainIntegrationTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val observer: Observer<MainViewModel.UiModel> = mock()
    private val component: TestComponent = DaggerTestComponent.factory().create()
    private lateinit var localDataSource: FakeLocalDataSource
    private lateinit var vm: MainViewModel

    @Before
    fun setUp() {
        vm = component.plus(MainActivityModule()).mainViewModel
        localDataSource = component.localDataSource as FakeLocalDataSource
        localDataSource.movies = defaultFakeMovies
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `data is loaded from server when local source is empty`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        vm.model.observeForever(observer)

        vm.onCoarsePermissionRequested()

        verify(observer).onChanged(
                ArgumentMatchers.refEq(MainViewModel.UiModel.Content(defaultFakeMovies))
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `data is loaded from local source when available`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val fakeLocalMovies = listOf(mockedMovie.copy(10), mockedMovie.copy(11))
        val localDataSource = component.localDataSource as FakeLocalDataSource
        localDataSource.movies = fakeLocalMovies
        vm.model.observeForever(observer)

        vm.onCoarsePermissionRequested()

        verify(observer).onChanged(
                ArgumentMatchers.refEq(MainViewModel.UiModel.Content(fakeLocalMovies))
        )
    }
}