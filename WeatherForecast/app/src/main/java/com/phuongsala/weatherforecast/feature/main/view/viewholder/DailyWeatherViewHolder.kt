package com.phuongsala.weatherforecast.feature.main.view.viewholder

import android.view.View
import com.phuongsala.weatherforecast.base.BaseViewHolder
import com.phuongsala.weatherforecast.common.OnItemClickListener
import com.phuongsala.weatherforecast.databinding.ItemDailyWeatherBinding
import com.phuongsala.weatherforecast.feature.main.model.WeatherInfoModel
import com.phuongsala.weatherforecast.feature.main.viewmodel.ItemWeatherViewModel

class DailyWeatherViewHolder(itemView: View, listener: OnItemClickListener?) :
    BaseViewHolder(itemView) {

    init {
        (binding as ItemDailyWeatherBinding).viewModel = ItemWeatherViewModel(listener)
    }

    override fun <T> bind(data: T) {
        (binding as ItemDailyWeatherBinding).viewModel?.liveData?.value = data as WeatherInfoModel
        super.bind(data)
    }

}