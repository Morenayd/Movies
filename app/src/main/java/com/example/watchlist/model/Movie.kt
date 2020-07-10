package com.example.towatchlist.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movie_table")
@Parcelize
class Movie (@PrimaryKey val id: Int,
             val releaseDate: String,
             val title: String,
             val summary: String,
             val poster: Int) : Parcelable