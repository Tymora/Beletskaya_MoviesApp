package com.tymora.beletskaya_moviesapp.listMovies.data.local

import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.Country
import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.Genre
import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity
data class MovieEntity(
    val countries: List<Country>,
    val genres: List<Genre>,
    val imdbId: String,
    val nameEn: Any,
    val nameOriginal: String,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val ratingImdb: Double,
    val ratingKinopoisk: Double,
    val type: String,
    val year: Int,

    @PrimaryKey
    val kinopoiskId: Int, //todo уточнить

)