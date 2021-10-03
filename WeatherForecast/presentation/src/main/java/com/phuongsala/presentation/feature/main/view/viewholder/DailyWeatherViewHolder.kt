package com.phuongsala.presentation.feature.main.view.viewholder

import android.view.View
import com.phuongsala.presentation.base.BaseViewHolder
import com.phuongsala.presentation.common.OnItemClickListener
import com.phuongsala.presentation.databinding.ItemDailyWeatherBinding
import com.phuongsala.presentation.feature.main.model.WeatherInfoModel
import com.phuongsala.presentation.feature.main.viewmodel.ItemWeatherViewModel

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