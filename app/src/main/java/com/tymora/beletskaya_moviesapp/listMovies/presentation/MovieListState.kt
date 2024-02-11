package com.tymora.beletskaya_moviesapp.listMovies.presentation

import com.tymora.beletskaya_moviesapp.listMovies.domain.model.TopMovies
data class MovieListState(
    val isLoading: Boolean = false,

    val popularMovieListPage: Int = 1,
    val upcomingMovieListPage: Int = 1,

    val isCurrentPopularScreen: Boolean = true,

    val popularTopMoviesList: List<TopMovies> = emptyList(),
    val upcomingTopMoviesList: List<TopMovies> = emptyList()
)