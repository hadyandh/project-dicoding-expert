package com.hunhun.animelib.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AnimeListResponse(
	@field:SerializedName("data")
	val data: List<AnimeResponse>? = null
)

data class AnimeResponse(

	@field:SerializedName("title_japanese")
	val titleJapanese: String? = null,

	@field:SerializedName("favorites")
	val favorites: Int? = null,

	@field:SerializedName("year")
	val year: Int? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("scored_by")
	val scoredBy: Int? = null,

	@field:SerializedName("title_synonyms")
	val titleSynonyms: List<String>? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("trailer")
	val trailer: Trailer? = null,

	@field:SerializedName("duration")
	val duration: String? = null,

	@field:SerializedName("score")
	val score: Double? = null,

	@field:SerializedName("themes")
	val themes: List<ThemesItem>? = null,

	@field:SerializedName("approved")
	val approved: Boolean? = null,

	@field:SerializedName("genres")
	val genres: List<GenresItem>? = null,

	@field:SerializedName("popularity")
	val popularity: Int? = null,

	@field:SerializedName("members")
	val members: Int? = null,

	@field:SerializedName("title_english")
	val titleEnglish: String? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("season")
	val season: String? = null,

	@field:SerializedName("airing")
	val airing: Boolean? = null,

	@field:SerializedName("episodes")
	val episodes: String? = null,

	@field:SerializedName("images")
	val images: ImagesItem? = null,

	@field:SerializedName("studios")
	val studios: List<StudiosItem>? = null,

	@field:SerializedName("mal_id")
	val id: String? = null,

	@field:SerializedName("titles")
	val titles: List<TitlesItem>? = null,

	@field:SerializedName("synopsis")
	val synopsis: String? = null,

	@field:SerializedName("explicit_genres")
	val explicitGenres: List<ExplicitGenresItem>? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("background")
	val background: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("demographics")
	val demographics: List<DemographicsItem>? = null
)

data class Trailer(

	@field:SerializedName("embed_url")
	val embedUrl: String? = null,

	@field:SerializedName("youtube_id")
	val youtubeId: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class ImagesItem(
	@field:SerializedName("jpg")
	val jpg: ImageJpg? = null
)

data class ImageJpg(

	@field:SerializedName("large_image_url")
	val largeImageUrl: String? = null,

	@field:SerializedName("small_image_url")
	val smallImageUrl: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null
)

data class GenresItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class ThemesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class ExplicitGenresItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class DemographicsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class StudiosItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class TitlesItem(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
