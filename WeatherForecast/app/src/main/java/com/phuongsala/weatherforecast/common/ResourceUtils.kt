package com.phuongsala.weatherforecast.common

import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.phuongsala.weatherforecast.MainApp

object ResourceUtils {

    fun getDrawable(resId: Int): Drawable? {
        return ContextCompat.getDrawable(MainApp.instance, resId)
    }

    fun getString(strId: Int): String {
        return MainApp.instance.getString(strId)
    }

    fun getColor(colorId: Int): Int {
        return ContextCompat.getColor(MainApp.instance, colorId)
    }
}