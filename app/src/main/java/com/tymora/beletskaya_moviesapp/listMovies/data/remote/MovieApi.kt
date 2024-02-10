package com.tymora.beletskaya_moviesapp.listMovies.data.remote

import com.tymora.beletskaya_moviesapp.listMovies.data.remote.responded.ListMovie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("api/v2.2/films/collections?type=TOP_250_MOVIES")
    suspend fun getMoviesList(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): ListMovie

    companion object{
        const val URL = ""
        const val IMAGE_URL = "https://kinopoiskapiunofficial.tech/images/posters/kp/435.jpg"
        const val API_KEY = "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b"
    }
}