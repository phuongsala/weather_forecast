package com.phuongsala.presentation.feature.main.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.phuongsala.presentation.base.BaseAdapter
import com.phuongsala.presentation.feature.main.model.WeatherInfoModel

class MainAdapter : BaseAdapter<WeatherInfoModel>() {

    override fun getDiffItem(): DiffUtil.ItemCallback<WeatherInfoModel> {
        return object : DiffUtil.ItemCallback<WeatherInfoModel>() {
            override fun areItemsTheSame(
                oldItem: WeatherInfoModel,
                newItem: WeatherInfoModel
            ): Boolean {
                return oldItem.dt == newItem.dt
            }

            override fun areContentsTheSame(
                oldItem: WeatherInfoModel,
                newItem: WeatherInfoModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}