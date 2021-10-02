package com.phuongsala.data.repository

import com.phuongsala.data.BuildConfig
import com.phuongsala.data.api.ApiService
import com.phuongsala.data.api.runWithCatchError
import com.phuongsala.data.db.WeatherInfoDatabase
import com.phuongsala.data.mapper.toLocalWeatherInfo
import com.phuongsala.data.mapper.toWeatherInfo
import com.phuongsala.data.mapper.toWeatherInfoResponse
import com.phuongsala.domain.entity.Response
import com.phuongsala.domain.entity.WeatherInfo
import com.phuongsala.domain.repository.IWeatherInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherInfoRepository @Inject constructor(
    private val apiService: ApiService,
    private val database: WeatherInfoDatabase
) : IWeatherInfoRepository {

    override suspend fun getWeatherInfo(city: String): Flow<Response<List<WeatherInfo>>> {
        return flow {
            // get local data
            var localData = database.getWeatherInfoDao().getWeatherInfo(city)
            // if having cached data, update it to UI
            if (localData.isNullOrEmpty().not()) {
                val responseData = localData.map { o -> o.toWeatherInfoResponse() }
                val data = responseData.map { o -> o.toWeatherInfo() }
                // update UI
                emit(Response.Success(data))
            } else { // get remote data
                runWithCatchError(
                    call = suspend {
                        apiService.getWeatherForecast(
                            query = city,
                            count = 7,
                            appId = BuildConfig.APP_ID
                        )
                    },
                    success = {
                        val responseData = it.weathers
                        // update UI
                        val data = responseData.map { o -> o.toWeatherInfo() }
                        emit(Response.Success(data))
                        // save local database
                        localData = responseData.map { o -> o.toLocalWeatherInfo(city) }
                        database.getWeatherInfoDao().saveWeatherInfo(localData)
                    },
                    failure = {
                        emit(Response.Failure(it.error))
                    }
                )
            }
        }
    }

    override suspend fun removeWeatherInfo() {
        database.getWeatherInfoDao().removeWeatherInfo()
    }

}