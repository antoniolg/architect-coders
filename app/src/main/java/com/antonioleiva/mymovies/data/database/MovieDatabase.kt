package com.antonioleiva.mymovies.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movie-db"
        ).build()
    }

    abstract fun movieDao(): MovieDao
}