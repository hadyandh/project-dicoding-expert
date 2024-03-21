package com.hunhun.animelib.core.domain.usecase

import com.hunhun.animelib.core.domain.model.Anime
import com.hunhun.animelib.core.domain.repository.IAnimeRepository
import javax.inject.Inject

class AnimeInteractor @Inject constructor (private val animeRepository: IAnimeRepository): AnimeUseCase {
    override fun getAllAnime() = animeRepository.getAllAnime()

    override fun getFavoriteAnime() = animeRepository.getFavoriteAnime()

    override fun setFavoriteAnime(anime: Anime, state: Boolean) = animeRepository.setFavoriteAnime(anime, state)
}