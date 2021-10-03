package com.phuongsala.domain.entity

data class WeatherInfo(
    val dt: String,
    val avgTemp: String,
    val humidity: String,
    val pressure: String,
    val desc: String
)

fun getSampleWeatherInfo() = WeatherInfo(
    dt = "CN, 03 Th10 2021",
    avgTemp = "26,5 C",
    humidity = "76%",
    pressure = "1011",
    desc = "moderate rain"
)