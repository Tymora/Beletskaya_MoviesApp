package com.tymora.beletskaya_moviesapp.listMovies.domain.model

data class TopMovies(
    val countries: String,
    val genres:String,
    val imdbId: String,
    val kinopoiskId: Int,
    val nameEn: String,
    val nameOriginal: String,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val ratingImdb: Double,
    val ratingKinopoisk: Double,
    val type: String,
    val year: Int,

    val category: String
)