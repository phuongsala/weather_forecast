package com.phuongsala.data.di

import com.phuongsala.data.repository.WeatherInfoRepository
import com.phuongsala.domain.repository.IWeatherInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindForecastData(impl: WeatherInfoRepository): IWeatherInfoRepository

}