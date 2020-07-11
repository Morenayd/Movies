package com.example.watchlist.repository


import android.os.AsyncTask
import com.example.towatchlist.model.Movie
import com.example.watchlist.MovieApplication
import com.example.watchlist.database.MovieDao
import com.example.watchlist.model.Movies

class RoomRepository: MovieRepository {

    private val movieDao: MovieDao = MovieApplication.database.movieDao()
    private val allMovies: List<Movie>

    init {
        if(movieDao.getAllMovies().isNullOrEmpty()) {
            movieDao.insertAllMovies(Movies.movieList)
        }
        allMovies = movieDao.getAllMovies()
    }

    override fun deleteMovie(movie: Movie) {
        movieDao.deleteMovie(movie)
    }

    override fun getAllMovies() = allMovies

}