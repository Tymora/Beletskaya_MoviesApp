package com.tymora.beletskaya_moviesapp.listMovies.domain.repository

import com.tymora.beletskaya_moviesapp.listMovies.domain.model.TopMovies
import com.tymora.beletskaya_moviesapp.listMovies.utill.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<TopMovies>>>

    suspend fun getMovie(id: Int): Flow<Resource<TopMovies>>
}