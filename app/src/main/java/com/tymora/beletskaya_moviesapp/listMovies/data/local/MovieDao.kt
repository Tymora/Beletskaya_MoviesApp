package com.tymora.beletskaya_moviesapp.listMovies.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MovieDao {
    @Upsert
    suspend fun upsertMovieList(movieList: List<MovieEntity>)

    @Query("Select * FROM MovieEntity WHERE kinopoiskId = :kinopoiskId ")
    suspend fun getMovieById(kinopoiskId: Int): MovieEntity

    @Query("Select * FROM MovieEntity WHERE genres = :genres ")
    suspend fun getMovieListByCategory(genres: String): List<MovieEntity>
}