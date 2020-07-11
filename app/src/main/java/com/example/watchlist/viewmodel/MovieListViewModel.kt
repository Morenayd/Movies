package com.example.watchlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.towatchlist.model.Movie
import com.example.watchlist.repository.RoomRepository

class MovieListViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RoomRepository()

    fun getMovies(): List<Movie> {
        return repository.getAllMovies()
    }

}