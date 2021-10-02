package com.phuongsala.domain.di

import com.phuongsala.domain.usecase.IWeatherInfoUseCase
import com.phuongsala.domain.usecase.WeatherInfoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DomainModule {

    @Binds
    abstract fun bindWeatherInfoUseCase(impl: WeatherInfoUseCase): IWeatherInfoUseCase
}