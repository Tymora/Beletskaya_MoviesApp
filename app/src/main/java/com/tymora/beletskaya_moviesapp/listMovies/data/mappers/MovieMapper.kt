package com.tymora.beletskaya_moviesapp.listMovies.data.mappers

import com.tymora.beletskaya_moviesapp.listMovies.data.local.MovieEntity
import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.MovieDto
import com.tymora.beletskaya_moviesapp.listMovies.domain.model.TopMovies

fun MovieDto.toMovieEntity(
    category: String
): MovieEntity {
    return MovieEntity(
        imdbId = imdbId?: "",
        kinopoiskId = kinopoiskId,
        nameEn = nameEn?: "",
        nameOriginal = nameOriginal?: "",
        nameRu = nameRu,
        posterUrl = posterUrl,
        posterUrlPreview = posterUrlPreview,
        ratingImdb = ratingImdb,
        ratingKinopoisk = ratingKinopoisk,
        type = type,
        year = year,
        genres = genres?.joinToString(",") { it.genre }?: "" ,
        countries = countries?.joinToString(",") { it.country }?: "",

        category = category

    )
}


fun MovieEntity.toTopMovies(
    category: String
): TopMovies {
    return TopMovies(
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
        category = category
    )
}