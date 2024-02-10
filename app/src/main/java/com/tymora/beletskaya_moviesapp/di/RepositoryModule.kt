package com.tymora.beletskaya_moviesapp.di

import com.tymora.beletskaya_moviesapp.listMovies.data.repository.MovieListRepositoryImpl
import com.tymora.beletskaya_moviesapp.listMovies.domain.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieListRepository(
        movieListRepositoryImpl: MovieListRepositoryImpl
    ): MovieListRepository

}