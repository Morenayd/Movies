package com.example.watchlist.ui.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.watchlist.R
import com.example.watchlist.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    val binding = DataBindingUtil.inflate<FragmentMovieDetailBinding>(inflater,
        R.layout.fragment_movie_detail, container, false)
    val args = MovieDetailFragmentArgs.fromBundle(
        requireArguments()
    )
    binding.poster.setImageResource(args.movie.poster)
    binding.titleText.text = args.movie.title
    binding.releaseDate.text = args.movie.releaseDate
    binding.summary.text = args.movie.summary
    setHasOptionsMenu(true)
    return binding.root
}
}