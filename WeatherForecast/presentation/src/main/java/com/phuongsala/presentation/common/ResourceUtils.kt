package com.phuongsala.presentation.common

import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.phuongsala.presentation.App

object ResourceUtils {

    fun getDrawable(resId: Int): Drawable? {
        return ContextCompat.getDrawable(App.instance, resId)
    }

    fun getString(strId: Int): String {
        return App.instance.getString(strId)
    }

    fun getColor(colorId: Int): Int {
        return ContextCompat.getColor(App.instance, colorId)
    }
}