package com.example.watchlist.repository

import androidx.lifecycle.LiveData
import com.example.towatchlist.model.Movie

interface MovieRepository {

    fun insertAllMovies(movies: List<Movie>)

    fun deleteMovie(movie: Movie)

    fun getAllMovies(): List<Movie>

}