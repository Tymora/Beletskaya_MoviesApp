package com.tymora.beletskaya_moviesapp.listMovies.domain.model

import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.Country
import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.Genre
import androidx.room.PrimaryKey

data class Movie(
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