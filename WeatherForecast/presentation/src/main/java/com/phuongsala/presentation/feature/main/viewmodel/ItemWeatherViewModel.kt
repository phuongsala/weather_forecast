package com.phuongsala.presentation.feature.main.viewmodel

import com.phuongsala.presentation.base.BaseItemModel
import com.phuongsala.presentation.base.BaseItemViewModel
import com.phuongsala.presentation.common.OnItemClickListener
import com.phuongsala.presentation.feature.main.model.WeatherInfoModel

class ItemWeatherViewModel(listener: OnItemClickListener?) :
    BaseItemViewModel<WeatherInfoModel>() {

    init {
        onItemClickListener = listener
    }

    override fun onItemClicked(data: BaseItemModel) {
        super.onItemClicked(data as WeatherInfoModel)
    }
}