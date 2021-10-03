package com.phuongsala.presentation.di

import android.content.Context
import com.phuongsala.presentation.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule{
    @Provides
    @Singleton
    fun provideApplication(): Context {
        return App.instance
    }
}

