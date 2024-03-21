package com.hunhun.animelib.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime_favorite")
data class AnimeEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "synopsis")
    var synopsis: String,

    @ColumnInfo(name = "banner")
    var banner: String,

    @ColumnInfo(name = "episode")
    var episode: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "score")
    var score: Double,

    @ColumnInfo(name = "season")
    var season: String,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)
