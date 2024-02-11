package com.tymora.beletskaya_moviesapp.listMovies.presentation
import com.tymora.beletskaya_moviesapp.listMovies.domain.model.TopMovies
data class DetailsState(
    val isLoading: Boolean = false,
    val movie: TopMovies? = null
)