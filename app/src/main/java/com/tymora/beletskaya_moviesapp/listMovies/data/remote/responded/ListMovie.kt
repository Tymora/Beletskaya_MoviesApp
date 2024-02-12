package com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded


data class ListMovie(
    val page: Int,
    val items: List<MovieDto>,
    val total: Int,
    val totalPages: Int,
    val detailsMovie: List<MovieDetailsData>
)