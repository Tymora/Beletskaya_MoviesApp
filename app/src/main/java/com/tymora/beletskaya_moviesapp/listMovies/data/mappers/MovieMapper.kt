package com.tymora.beletskaya_moviesapp.listMovies.data.mappers

import com.tymora.beletskaya_moviesapp.listMovies.data.local.MovieEntity
import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.MovieDto
import com.tymora.beletskaya_moviesapp.listMovies.domain.model.Movie

fun MovieDto.toMovieEntity(
    category: String
): MovieEntity {
    return MovieEntity(
        imdbId = imdbId?: "",
        kinopoiskId = kinopoiskId?: -1,
        nameEn = nameEn?: "",
        nameOriginal = nameOriginal?: "",
        nameRu = nameRu?: "",
        posterUrl = posterUrl?: "",
        posterUrlPreview = posterUrlPreview?: "",
        ratingImdb = ratingImdb?: 0.0,
        ratingKinopoisk = ratingKinopoisk?: 0.0,
        type = type?: "",
        year = year?: 0,

        genres = genres?.joinToString(",") ?: "",
        countries = countries?.joinToString(",") ?: "",

        category = category

    )
}


fun MovieEntity.toMovie(
    category: String
): Movie {
    return Movie(
        countries = countries,
        genres = genres,
        imdbId = imdbId,
        kinopoiskId = kinopoiskId,
        nameEn = nameEn,
        nameOriginal = nameOriginal,
        nameRu = nameRu,
        posterUrl = posterUrl,
        posterUrlPreview = posterUrlPreview,
        ratingImdb = ratingImdb,
        ratingKinopoisk = ratingKinopoisk,
        type = type,
        year = year,
        category = category,
    )
}