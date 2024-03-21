package com.hunhun.animelib.core.data

import com.hunhun.animelib.core.data.source.local.LocalDataSource
import com.hunhun.animelib.core.data.source.remote.RemoteDataSource
import com.hunhun.animelib.core.data.source.remote.network.ApiResponse
import com.hunhun.animelib.core.data.source.remote.response.AnimeResponse
import com.hunhun.animelib.core.domain.model.Anime
import com.hunhun.animelib.core.domain.repository.IAnimeRepository
import com.hunhun.animelib.core.utils.AppExecutors
import com.hunhun.animelib.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IAnimeRepository {

    override fun getAllAnime(): Flow<Resource<List<Anime>>> =
        object : NetworkBoundResource<List<Anime>, List<AnimeResponse>>() {
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getAllAnime().map { DataMapper.mapEntitiesToDomain(it) }

            }

            override fun shouldFetch(data: List<Anime>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<AnimeResponse>>> =
                remoteDataSource.getAllAnime()

            override suspend fun saveCallResult(data: List<AnimeResponse>) {
                val animeList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertAnime(animeList)
            }
        }.asFlow()

    override fun getFavoriteAnime(): Flow<List<Anime>> {
        return localDataSource.getFavoriteAnime().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteAnime(anime: Anime, state: Boolean) {
        val animeEntity = DataMapper.mapDomainToEntity(anime)
        appExecutors.diskIO().execute { localDataSource.setFavoriteAnime(animeEntity, state) }
    }
}

