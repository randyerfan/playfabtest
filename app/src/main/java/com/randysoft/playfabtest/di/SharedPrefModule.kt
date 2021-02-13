package com.randysoft.playfabtest.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.randysoft.playfabtest.utils.SharedPrefs
import com.randysoft.playfabtest.utils.StaticValues
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object SharedPrefModule {
    @Singleton
    @Provides
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences {

        return context.getSharedPreferences(StaticValues.SHARED_PREFS_KEY, MODE_PRIVATE)

    }

    @Singleton
    @Provides
    fun providerSharedPrefEditor(sharedPreferences: SharedPreferences): SharedPrefs {
        return SharedPrefs(sharedPreferences)
    }
}