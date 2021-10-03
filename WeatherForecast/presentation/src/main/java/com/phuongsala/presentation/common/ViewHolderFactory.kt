package com.phuongsala.presentation.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.phuongsala.presentation.R
import com.phuongsala.presentation.base.BaseViewHolder
import com.phuongsala.presentation.feature.main.view.viewholder.DailyWeatherViewHolder

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