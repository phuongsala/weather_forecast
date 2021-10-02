package com.phuongsala.weatherforecast.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.phuongsala.weatherforecast.R
import com.phuongsala.weatherforecast.base.BaseViewHolder
import com.phuongsala.weatherforecast.feature.main.view.viewholder.DailyWeatherViewHolder

object ViewHolderFactory {

    const val ITEM_DAILY_WEATHER: Int = 0

    fun createViewHolder(
        viewGroup: ViewGroup,
        viewType: Int,
        listener: OnItemClickListener?
    ): BaseViewHolder {

        val ctx = viewGroup.context

        return when (viewType) {
            ITEM_DAILY_WEATHER -> DailyWeatherViewHolder(
                LayoutInflater.from(ctx).inflate(R.layout.item_daily_weather, viewGroup, false),
                listener
            )
            else -> BaseViewHolder(viewGroup.rootView)
        }
    }
}