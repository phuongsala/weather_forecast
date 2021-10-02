package com.phuongsala.domain.repository

import com.phuongsala.domain.entity.Response
import com.phuongsala.domain.entity.WeatherInfo
import kotlinx.coroutines.flow.Flow

interface IWeatherInfoRepository {

    suspend fun getWeatherInfo(city: String): Flow<Response<List<WeatherInfo>>>

    suspend fun removeWeatherInfo()
}