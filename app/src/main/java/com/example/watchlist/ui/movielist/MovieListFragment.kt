package com.example.watchlist.ui.movielist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.towatchlist.model.Movie
import com.example.watchlist.MovieApplication
import com.example.watchlist.R
import com.example.watchlist.SharedPrefs
import com.example.watchlist.database.MovieDao
import com.example.watchlist.database.MovieDatabase
import com.example.watchlist.databinding.FragmentMovieListBinding
import com.example.watchlist.model.Movies
import com.example.watchlist.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : Fragment(), MovieListAdapter.MovieListClickListener {

    private lateinit var database: MovieDatabase
    private lateinit var dao: MovieDao
    private lateinit var movieViewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMovieListBinding>(
            inflater, R.layout.fragment_movie_list, container, false)
        setHasOptionsMenu(true)

        //set up database
        database = MovieApplication.database
        dao = database.movieDao()
        if(dao.getAllMovies().isEmpty()) {
            dao.insertAllMovies(Movies.movieList)
        }

        //viewmodel
        movieViewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie_list_recyclerview.layoutManager = LinearLayoutManager(activity)
        //adapter
        val adapter = MovieListAdapter(this)
        movie_list_recyclerview.adapter = adapter
        adapter.getMovies(dao.getAllMovies())
    }

    override fun itemClicked(movie: Movie) {
        showMovieDetail(movie)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> logOut()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showMovieDetail(movie: Movie) {
        this.findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(movie))
    }

    private fun logOut() {
        SharedPrefs.clearLoginStatus()
        this.findNavController().navigate(MovieListFragmentDirections.actionMovieListFragmentToLoginFragment())
    }

}