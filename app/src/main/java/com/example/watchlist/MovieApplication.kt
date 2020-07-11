package com.example.watchlist

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.watchlist.database.MovieDatabase

class MovieApplication: Application() {
    companion object {
        lateinit var database: MovieDatabase
        
        private lateinit var instance: MovieApplication
        
        fun getApplicationContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()

        database = Room.databaseBuilder(this, MovieDatabase::class.java, "movie_table").allowMainThreadQueries().build()
    }
    
}
