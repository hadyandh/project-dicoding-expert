package com.hunhun.animelib.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    var id: String,
    var title: String,
    var synopsis: String,
    var banner: String,
    var episode: String,
    var duration: String,
    var status: String,
    var score: Double,
    var season: String,
    var isFavorite: Boolean = false
) : Parcelable
