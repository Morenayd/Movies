package com.example.watchlist.viewmodel

import androidx.lifecycle.AndroidViewModel
import com.example.towatchlist.model.Movie
import com.example.watchlist.MovieApplication
import com.example.watchlist.repository.RoomRepository

class MovieListViewModel(application: MovieApplication): AndroidViewModel(application) {

    private val repository = RoomRepository()
    private val allMovies = repository.getAllMovies()

    fun insertAllMovies() = repository.insertAllMovies(allMovies)

    fun getMovies() {
        repository.getAllMovies()
    }

    fun deleteMovies(movie: Movie) = repository.deleteMovie(movie)

}