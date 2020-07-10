package com.example.watchlist.ui.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.towatchlist.model.Movie
import com.example.watchlist.R

class MovieListAdapter(val clickListener: MovieListClickListener): RecyclerView.Adapter<MovieListViewHolder>() {

    private var movieList = listOf<Movie>()

    interface MovieListClickListener {
        fun itemClicked(movie: Movie)
    }

    fun getMovies(movies: List<Movie>) {
        movieList = movies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MovieListViewHolder(view)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.title.text = movieList[position].title
        holder.poster.setImageResource(movieList[position].poster)
        holder.summaryText.text = movieList[position].summary
        holder.releaseDate.text = movieList[position].releaseDate
        holder.itemView.setOnClickListener {
            clickListener.itemClicked(movieList[position])
        }
    }

}