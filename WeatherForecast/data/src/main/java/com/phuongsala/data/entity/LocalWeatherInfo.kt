package com.phuongsala.data.entity

import androidx.room.Entity

@Entity(tableName = "WeatherInfo", primaryKeys = ["cityName", "dt"])
data class LocalWeatherInfo(
    val cityName: String,
    val dt: Long,
    val temp: String,
    val pressure: Int,
    val humidity: Int,
    val weathers: String
)