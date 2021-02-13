package com.randysoft.playfabtest.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.randysoft.playfabtest.network.MainRetrofit
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext context : Context, gson: Gson): Retrofit.Builder {
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            .build()
        return Retrofit.Builder()
            .baseUrl("https://3766a.playfabapi.com/Client/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideMainService(retrofit: Retrofit.Builder): MainRetrofit{
        return retrofit
            .build()
            .create(MainRetrofit::class.java)
    }
}