package com.phuongsala.data.entity

import com.google.gson.annotations.SerializedName

data class WeatherForecastResponse(
    @SerializedName("cnt") val cnt: Int,
    @SerializedName("list") val weathers: List<WeatherInfoResponse>
)

data class WeatherInfoResponse(
    @SerializedName("dt") val dt: Long,
    @SerializedName("temp") val temp: TempResponse,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("weather") val weathers: List<WeatherDescResponse>
)

data class TempResponse(
    @SerializedName("day") val day: Float,
    @SerializedName("min") val min: Float,
    @SerializedName("max") val max: Float,
    @SerializedName("night") val night: Float,
    @SerializedName("eve") val eve: Float,
    @SerializedName("morn") val morn: Float,
)

data class WeatherDescResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)
