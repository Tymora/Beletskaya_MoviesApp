package com.tymora.beletskaya_moviesapp.listMovies.details

import com.tymora.beletskaya_moviesapp.listMovies.domain.model.TopMovies
data class DetailsState(
    val isLoading: Boolean = false,
    val topMovies: TopMovies? = null
)
