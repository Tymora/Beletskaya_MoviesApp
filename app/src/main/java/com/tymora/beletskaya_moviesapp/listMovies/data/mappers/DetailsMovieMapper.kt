package com.tymora.beletskaya_moviesapp.listMovies.data.mappers

import com.tymora.beletskaya_moviesapp.listMovies.data.local.MovieEntity
import com.tymora.beletskaya_moviesapp.listMovies.data.local.detail.MovieEntityDetails
import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.details.MovieDetailsData
import com.tymora.beletskaya_moviesapp.listMovies.domain.model.DetailsMovie
import com.tymora.beletskaya_moviesapp.listMovies.domain.model.TopMovies

fun MovieDetailsData.toMovieEntityDetails(
    category: String
): MovieEntityDetails {
    return MovieEntityDetails(
        completed = completed,
        countries = countries,
        coverUrl = coverUrl,
        description = description,
        editorAnnotation = editorAnnotation,
        endYear = endYear,
        filmLength = filmLength,
        genres = genres,
        has3D = has3D,
        hasImax = hasImax,
        imdbId = imdbId,
        isTicketsAvailable = isTicketsAvailable,
        kinopoiskHDId = kinopoiskHDId,
        kinopoiskId = kinopoiskId,
        lastSync = lastSync,
        logoUrl = logoUrl,
        nameEn = nameEn,
        nameOriginal = nameOriginal,
        nameRu = nameRu,
        posterUrl = posterUrl,
        posterUrlPreview = posterUrlPreview,
        productionStatus = productionStatus,
        ratingAgeLimits = ratingAgeLimits,
        ratingAwait = ratingAwait,
        ratingAwaitCount = ratingAwaitCount,
        ratingFilmCritics = ratingFilmCritics,
        ratingFilmCriticsVoteCount = ratingFilmCriticsVoteCount,
        ratingGoodReview = ratingGoodReview,
        ratingGoodReviewVoteCount = ratingGoodReviewVoteCount,
        ratingImdb = ratingImdb,
        ratingImdbVoteCount = ratingImdbVoteCount,
        ratingKinopoisk = ratingKinopoisk,
        ratingKinopoiskVoteCount = ratingImdbVoteCount,
        ratingMpaa = ratingMpaa,
        ratingRfCritics = ratingRfCritics,
        ratingRfCriticsVoteCount = ratingRfCriticsVoteCount,
        reviewsCount = reviewsCount,
        serial = serial,
        shortDescription = shortDescription,
        shortFilm = shortFilm,
        slogan = serial,
        startYear = startYear,
        type = type,
        webUrl = webUrl,
        year = year
    )
}

fun MovieEntityDetails.toDetailsMovie(
    category: String
): DetailsMovie {
    return DetailsMovie(
        completed = completed,
        countries = countries,
        coverUrl = coverUrl,
        description = description,
        editorAnnotation = editorAnnotation,
        endYear = endYear,
        filmLength = filmLength,
        genres = genres,
        has3D = has3D,
        hasImax = hasImax,
        imdbId = imdbId,
        isTicketsAvailable = isTicketsAvailable,
        kinopoiskHDId = kinopoiskHDId,
        kinopoiskId = kinopoiskId,
        lastSync = lastSync,
        logoUrl = logoUrl,
        nameEn = nameEn,
        nameOriginal = nameOriginal,
        nameRu = nameRu,
        posterUrl = posterUrl,
        posterUrlPreview = posterUrlPreview,
        productionStatus = productionStatus,
        ratingAgeLimits = ratingAgeLimits,
        ratingAwait = ratingAwait,
        ratingAwaitCount = ratingAwaitCount,
        ratingFilmCritics = ratingFilmCritics,
        ratingFilmCriticsVoteCount = ratingFilmCriticsVoteCount,
        ratingGoodReview = ratingGoodReview,
        ratingGoodReviewVoteCount = ratingGoodReviewVoteCount,
        ratingImdb = ratingImdb,
        ratingImdbVoteCount = ratingImdbVoteCount,
        ratingKinopoisk = ratingKinopoisk,
        ratingKinopoiskVoteCount = ratingImdbVoteCount,
        ratingMpaa = ratingMpaa,
        ratingRfCritics = ratingRfCritics,
        ratingRfCriticsVoteCount = ratingRfCriticsVoteCount,
        reviewsCount = reviewsCount,
        serial = serial,
        shortDescription = shortDescription,
        shortFilm = shortFilm,
        slogan = serial,
        startYear = startYear,
        type = type,
        webUrl = webUrl,
        year = year
    )
}