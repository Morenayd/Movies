package com.example.watchlist.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.towatchlist.model.Movie
import com.example.watchlist.MovieApplication
import com.example.watchlist.database.MovieDao

class RoomRepository: MovieRepository {
    
    private val movieDao: MovieDao = MovieApplication.database.movieDao()
    private val allMovies: LiveData<List<Movie>>

    init {
        allMovies = movieDao.getAllMovies()
    }

    override fun insertAllMovies(movies: List<Movie>) {
        InsertAsyncTask(movieDao).execute(movies)
    }

    override fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie)
    }


    override fun getAllMovies() = allMovies


    private class InsertAsyncTask internal constructor(private val dao: MovieDao): AsyncTask<LiveData<List<Movie>>, Void, Void>() {
        override fun doInBackground(vararg params: LiveData<List<Movie>>): Void? {
            dao.insertAllMovies(params[0])
            return null
        }

    }
}