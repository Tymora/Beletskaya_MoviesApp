package com.tymora.beletskaya_moviesapp.listMovies.data.local.detail

import androidx.room.Entity
import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.details.Country
import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.details.Genre


@Entity
data class MovieEntityDetails(
    val completed: Boolean,
    val countries: String,
    val coverUrl: String,
    val description: String,
    val editorAnnotation: Any,
    val endYear: Any,
    val filmLength: Int,
    val genres: String,
    val has3D: Boolean,
    val hasImax: Boolean,
    val imdbId: String,
    val isTicketsAvailable: Boolean,
    val kinopoiskHDId: String,
    val kinopoiskId: Int,
    val lastSync: String,
    val logoUrl: Any,
    val nameEn: Any,
    val nameOriginal: Any,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val productionStatus: Any,
    val ratingAgeLimits: String,
    val ratingAwait: Any,
    val ratingAwaitCount: Int,
    val ratingFilmCritics: Any,
    val ratingFilmCriticsVoteCount: Int,
    val ratingGoodReview: Int,
    val ratingGoodReviewVoteCount: Int,
    val ratingImdb: Double,
    val ratingImdbVoteCount: Int,
    val ratingKinopoisk: Double,
    val ratingKinopoiskVoteCount: Int,
    val ratingMpaa: Any,
    val ratingRfCritics: Any,
    val ratingRfCriticsVoteCount: Int,
    val reviewsCount: Int,
    val serial: Boolean,
    val shortDescription: String,
    val shortFilm: Boolean,
    val slogan: Any,
    val startYear: Any,
    val type: String,
    val webUrl: String,
    val year: Int
)