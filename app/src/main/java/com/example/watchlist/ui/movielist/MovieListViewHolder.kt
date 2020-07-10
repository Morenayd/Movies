package com.example.watchlist.ui.movielist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MovieListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var poster = itemView.movie_poster
    var summaryText = itemView.summary_snippet_text
    var releaseDate = itemView.releaseDate
    var title = itemView.poster
}