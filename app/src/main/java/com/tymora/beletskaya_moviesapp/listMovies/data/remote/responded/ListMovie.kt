package com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded

import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.details.MovieDetailsData


data class ListMovie(
    val page: Int,
    val items: List<MovieDto>,
    val total: Int,
    val totalPages: Int,
    val movie: List<MovieDetailsData>
)