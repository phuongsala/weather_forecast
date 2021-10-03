package com.phuongsala.presentation.feature.main.model

import com.phuongsala.presentation.base.BaseItemModel
import com.phuongsala.presentation.common.ViewHolderFactory.ITEM_DAILY_WEATHER

data class WeatherInfoModel(
    val dt: String,
    val avgTemp: String,
    val pressure: String,
    val humidity: String,
    val desc: String
) : BaseItemModel(ITEM_DAILY_WEATHER)
