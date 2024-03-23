package com.hunhun.animelib.di

import com.hunhun.animelib.core.domain.usecase.AnimeInteractor
import com.hunhun.animelib.core.domain.usecase.AnimeUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun provideAnimeUseCase(animeInteractor: AnimeInteractor): AnimeUseCase
}