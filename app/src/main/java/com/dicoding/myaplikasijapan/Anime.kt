package com.dicoding.myaplikasijapan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val name: String,
    val description: String,
    val photo: Int,
    val rating: Float
) : Parcelable
