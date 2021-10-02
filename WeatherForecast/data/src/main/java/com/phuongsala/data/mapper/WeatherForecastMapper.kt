package com.phuongsala.data.mapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.phuongsala.data.entity.LocalWeatherInfo
import com.phuongsala.data.entity.TempResponse
import com.phuongsala.data.entity.WeatherDescResponse
import com.phuongsala.data.entity.WeatherInfoResponse
import com.phuongsala.domain.entity.WeatherInfo
import java.text.SimpleDateFormat
import java.util.*

const val CELSIUS_SYMBOL = "\u2103"
const val PERCENT_SYMBOL = "%"
const val DATE_FORMAT = "EEE, dd MMM yyyy"

fun WeatherInfoResponse.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        dt = (dt * 1000).toTimeDisplay(),
        avgTemp = temp.getAvgTempDisplay(),
        humidity = "$humidity$PERCENT_SYMBOL",
        pressure = "$pressure",
        desc = weathers.joinToString { weather -> weather.description }
    )
}

fun WeatherInfoResponse.toLocalWeatherInfo(cityName: String): LocalWeatherInfo {
    return LocalWeatherInfo(
        cityName = cityName,
        dt = dt,
        temp = temp.toJson(),
        humidity = humidity,
        pressure = pressure,
        weathers = weathers.toJson()
    )
}

fun LocalWeatherInfo.toWeatherInfoResponse(): WeatherInfoResponse {
    return WeatherInfoResponse(
        dt = dt,
        temp = Gson().fromJson(temp, TempResponse::class.java),
        humidity = humidity,
        pressure = pressure,
        weathers = Gson().fromJson(
            weathers, object : TypeToken<List<WeatherDescResponse>?>() {}.type
        )
    )
}

fun Long.toTimeDisplay(): String {
    val simpleDateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
    val date = Date(this)
    return simpleDateFormat.format(date)
}

fun TempResponse.getAvgTempDisplay(): String {
    return "${String.format("%.1f", (max + min) / 2)} $CELSIUS_SYMBOL"
}

fun Any.toJson(): String {
    return Gson().toJson(this)
}