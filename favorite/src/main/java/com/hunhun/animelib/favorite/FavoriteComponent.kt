package com.hunhun.animelib.favorite

import android.content.Context
import com.hunhun.animelib.di.FavoriteModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(fragmentModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }

}