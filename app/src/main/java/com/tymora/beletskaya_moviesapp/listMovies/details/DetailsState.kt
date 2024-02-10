package com.tymora.beletskaya_moviesapp.listMovies.details

import com.tymora.beletskaya_moviesapp.listMovies.domain.model.Movie
data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)
