package com.phuongsala.data.api

import com.phuongsala.data.entity.TempUnit
import com.phuongsala.data.entity.WeatherForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/forecast/daily")
    suspend fun getWeatherForecast(
        @Query("q") query: String,
        @Query("cnt") count: Int,
        @Query("appid") appId: String,
        @Query("units") units: String = TempUnit.CELSIUS.value
    ): WeatherForecastResponse
}