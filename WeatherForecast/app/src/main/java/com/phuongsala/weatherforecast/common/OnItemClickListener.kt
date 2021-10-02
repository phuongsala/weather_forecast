package com.phuongsala.weatherforecast.common

import android.view.View

interface OnItemClickListener {
    fun onItemClicked(obj: Any?)
    fun onItemClicked(v: View, obj: Any?) {}
    fun onItemClicked(pos: Int, v: View?, obj: Any?) {}
}