package com.tymora.beletskaya_moviesapp.listMovies.data.remote

import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.ListMovie
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApi {

    @GET("api/v2.2/films/collections?type=TOP_250_MOVIES")
    suspend fun getMoviesList(
        @Query("page") page: Int,
        @Header("X-API-KEY") apiKey: String = API_KEY
    ): ListMovie

    @GET("api/v2.2/films") //Получить данные по 1 фильму
    suspend fun getMoviesDetails(
        @Header("X-API-KEY") apiKey: String = API_KEY
    ): ListMovie

    companion object{
        const val URL = "https://kinopoiskapiunofficial.tech/"
        const val API_KEY = "206ac5bc-dfea-4e14-a637-72966e7e3c70"
    }
}