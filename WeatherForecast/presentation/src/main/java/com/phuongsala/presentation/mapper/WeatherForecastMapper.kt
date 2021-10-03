package com.phuongsala.presentation.mapper

import com.phuongsala.domain.entity.WeatherInfo
import com.phuongsala.presentation.feature.main.model.WeatherInfoModel

fun WeatherInfo.toWeatherInfoModel(): WeatherInfoModel {
    return WeatherInfoModel(
        dt = dt,
        avgTemp = avgTemp,
        humidity = humidity,
        pressure = pressure,
        desc = desc
    )
}