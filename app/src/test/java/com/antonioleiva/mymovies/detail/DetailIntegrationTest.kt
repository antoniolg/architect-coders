package com.antonioleiva.mymovies.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.antonioleiva.mymovies.*
import com.antonioleiva.mymovies.ui.detail.DetailActivityModule
import com.antonioleiva.mymovies.ui.detail.DetailViewModel
import com.antonioleiva.mymovies.ui.main.MainActivityModule
import com.antonioleiva.mymovies.ui.main.MainViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers

class DetailIntegrationTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val observer: Observer<DetailViewModel.UiModel> = mock()
    private val component: TestComponent = DaggerTestComponent.factory().create()
    private lateinit var localDataSource: FakeLocalDataSource
    private lateinit var vm: DetailViewModel

    @Before
    fun setUp() {
        vm = component.plus(DetailActivityModule(1)).detaiViewModel
        localDataSource = component.localDataSource as FakeLocalDataSource
        localDataSource.movies = defaultFakeMovies
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `observing LiveData finds the movie`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        vm.model.observeForever(observer)

        verify(observer).onChanged(
                ArgumentMatchers.refEq(DetailViewModel.UiModel(mockedMovie.copy(1)))
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `favorite is updated in local data source`() = coroutinesTestRule.testDispatcher.runBlockingTest {
        vm.model.observeForever(observer)

        vm.onFavoriteClicked()

        assertTrue(localDataSource.findById(1).favorite)
    }
}