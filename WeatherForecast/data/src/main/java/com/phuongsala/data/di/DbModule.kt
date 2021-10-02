package com.phuongsala.data.di

import android.content.Context
import com.phuongsala.data.db.WeatherInfoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DbModule {

    @Provides
    @Singleton
    fun buildDatabase(context: Context): WeatherInfoDatabase {
        return WeatherInfoDatabase.build(context)
    }
}