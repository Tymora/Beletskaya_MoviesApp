package com.tymora.beletskaya_moviesapp.listMovies.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.tymora.beletskaya_moviesapp.listMovies.data.local.detail.MovieEntityDetails

@Dao
interface MovieDao {
    @Upsert
    suspend fun upsertMovieList(movieList: List<MovieEntity>)

    @Query("Select * FROM MovieEntity WHERE kinopoiskId = :kinopoiskId")
    suspend fun getMovieById(kinopoiskId: Int): MovieEntity

    @Query("SELECT * FROM MovieEntity WHERE category = :category")
    suspend fun getMovieListByCategory(category: String): List<MovieEntity>

//    @Query("SELECT * FROM MOVIEENTITYDETAILS WHERE kinopoiskId = :kinopoiskId")
//    suspend fun getMovieDetails(kinopoiskId: Int): List<MovieEntityDetails>

}