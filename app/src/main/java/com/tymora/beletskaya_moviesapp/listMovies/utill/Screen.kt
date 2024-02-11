package com.tymora.beletskaya_moviesapp.listMovies.utill

sealed class Screen(val rout: String) {
    object Home : Screen("main")
    object PopularMovieList : Screen("popularMovie")
    object FavoriteMovieList : Screen("favoriteMovie")
    object Details : Screen("details")
}