package com.antonioleiva.mymovies

class TestApplication: MoviesApp() {

    override fun initMoviesComponent() = DaggerUiTestComponent.factory().create(this)

}