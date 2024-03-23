package com.hunhun.animelib.core.utils

import com.hunhun.animelib.core.data.source.local.entity.AnimeEntity
import com.hunhun.animelib.core.data.source.remote.response.AnimeResponse
import com.hunhun.animelib.core.domain.model.Anime

object DataMapper {
    fun mapResponsesToEntities(input: List<AnimeResponse>): List<AnimeEntity> {
        val animeList = ArrayList<AnimeEntity>()
        input.map {
            val anime = AnimeEntity(
                id = it.id ?: "",
                title = it.title ?: "",
                synopsis = it.synopsis ?: "",
                banner = it.images?.jpg?.imageUrl ?: "",
                episode = it.episodes ?: "0",
                duration = it.duration ?: "",
                status = it.status ?: "",
                score = it.score ?: 0.0,
                season = it.season ?: "",
            )
            animeList.add(anime)
        }
        return animeList
    }

    fun mapEntitiesToDomain(input: List<AnimeEntity>): List<Anime> =
        input.map {
            Anime(
                id = it.id,
                title = it.title,
                synopsis = it.synopsis,
                banner = it.banner,
                episode = it.episode,
                duration = it.duration,
                status = it.status,
                score = it.score,
                season = it.season,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(item: Anime) = AnimeEntity(
        id = item.id,
        title = item.title,
        synopsis = item.synopsis,
        banner = item.banner,
        episode = item.episode,
        duration = item.duration,
        status = item.status,
        score = item.score,
        season = item.season,
        isFavorite = item.isFavorite
    )

}