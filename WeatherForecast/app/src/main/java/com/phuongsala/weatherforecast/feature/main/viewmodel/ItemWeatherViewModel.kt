package com.phuongsala.weatherforecast.feature.main.viewmodel

import com.phuongsala.weatherforecast.base.BaseItemModel
import com.phuongsala.weatherforecast.base.BaseItemViewModel
import com.phuongsala.weatherforecast.common.OnItemClickListener
import com.phuongsala.weatherforecast.feature.main.model.WeatherInfoModel

class ItemWeatherViewModel(listener: OnItemClickListener?) :
    BaseItemViewModel<WeatherInfoModel>() {

    init {
        onItemClickListener = listener
    }

    override fun onItemClicked(data: BaseItemModel) {
        super.onItemClicked(data as WeatherInfoModel)
    }
}