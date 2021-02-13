package com.randysoft.playfabtest.di

import com.randysoft.playfabtest.network.MainRetrofit
import com.randysoft.playfabtest.repository.MainRepository
import com.randysoft.playfabtest.utils.SharedPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        mainRetrofit: MainRetrofit,
        prefs : SharedPrefs
    ): MainRepository {
        return MainRepository(mainRetrofit,prefs)
    }
}