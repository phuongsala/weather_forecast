package com.phuongsala.weatherforecast.feature.main.model

import com.phuongsala.weatherforecast.base.BaseItemModel
import com.phuongsala.weatherforecast.common.ViewHolderFactory.ITEM_DAILY_WEATHER

data class WeatherInfoModel(
    val dt: String,
    val avgTemp: String,
    val pressure: String,
    val humidity: String,
    val desc: String
) : BaseItemModel(ITEM_DAILY_WEATHER)
