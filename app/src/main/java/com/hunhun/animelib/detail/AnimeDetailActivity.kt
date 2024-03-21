package com.hunhun.animelib.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.hunhun.animelib.R
import com.hunhun.animelib.core.domain.model.Anime
import com.hunhun.animelib.databinding.ActivityAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailActivity : AppCompatActivity() {
    private val viewModel: AnimeDetailViewModel by viewModels()

    private lateinit var binding: ActivityAnimeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
    }

    private fun initData() {
        val animeData = intent.getParcelableExtra<Anime>(EXTRA_ANIME)
        initView(animeData)
    }

    private fun initView(anime: Anime?) {
        anime?.let {
            binding.titleTV.text = anime.title
            binding.ratingTV.text = anime.score.toString()
            binding.statusTV.text = anime.status
            binding.seasonTV.text = anime.season
            binding.synopsisTV.text = anime.synopsis

            Glide.with(this)
                .load(anime.banner)
                .into(binding.bannerIV)

            var statusFavorite = anime.isFavorite
            setStatusFavorite(statusFavorite)
            binding.favoriteMB.setOnClickListener {
                statusFavorite = !statusFavorite
                viewModel.setFavoriteAnime(anime, statusFavorite)
                setStatusFavorite(statusFavorite)
            }

            binding.backMB.setOnClickListener { finish() }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.favoriteMB.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            binding.favoriteMB.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_outline)
        }
    }

    companion object {
        const val EXTRA_ANIME = "EXTRA_ANIME"
    }
}