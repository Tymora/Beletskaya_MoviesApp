package com.tymora.beletskaya_moviesapp.listMovies.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase: RoomDatabase() {
    abstract val movieDao: MovieDao
}