package com.hunhun.animelib.detail

import androidx.lifecycle.ViewModel
import com.hunhun.animelib.core.domain.model.Anime
import com.hunhun.animelib.core.domain.usecase.AnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val animeUseCase: AnimeUseCase) : ViewModel() {
    fun setFavoriteAnime(anime: Anime, newStatus:Boolean) = animeUseCase.setFavoriteAnime(anime, newStatus)
}