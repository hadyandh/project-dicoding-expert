package com.hunhun.animelib.core.data.source.remote.network

import com.hunhun.animelib.core.data.source.remote.response.AnimeListResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("seasons/now")
    suspend fun getAnime(): AnimeListResponse
}