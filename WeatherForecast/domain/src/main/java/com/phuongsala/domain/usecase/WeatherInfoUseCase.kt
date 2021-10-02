package com.phuongsala.domain.usecase

import com.phuongsala.domain.entity.Response
import com.phuongsala.domain.entity.WeatherInfo
import com.phuongsala.domain.repository.IWeatherInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface IWeatherInfoUseCase {

    suspend fun getWeatherInfo(cityName: String): Flow<Response<List<WeatherInfo>>>

    suspend fun removeWeatherInfo()
}

class WeatherInfoUseCase @Inject constructor(private val repository: IWeatherInfoRepository) :
    IWeatherInfoUseCase {

    override suspend fun getWeatherInfo(cityName: String): Flow<Response<List<WeatherInfo>>> {
        return repository.getWeatherInfo(cityName)
    }

    override suspend fun removeWeatherInfo() {
        return repository.removeWeatherInfo()
    }
}