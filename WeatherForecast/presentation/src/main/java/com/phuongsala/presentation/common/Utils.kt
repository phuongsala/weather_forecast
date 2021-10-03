package com.phuongsala.presentation.common

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.provider.Settings.Secure.getString
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.phuongsala.presentation.App
import java.io.File

fun toast(message: String, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(App.instance, message, time).show()
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.checkIfDeviceWasRooted(): Boolean {
    val isEmulator = isEmulator(this)
    val buildTags = Build.TAGS
    return if (!isEmulator && buildTags != null && buildTags.contains("test-keys")) {
        true
    } else {
        var file = File("/system/app/Superuser.apk")
        if (file.exists()) {
            true
        } else {
            file = File ("/system/xbin/su")
            !isEmulator && file.exists()
        }
    }
}

@SuppressLint("HardwareIds")
fun isEmulator(context: Context): Boolean {
    val androidId = getString(context.contentResolver, "android_id")
    return "sdk" == Build.PRODUCT || "google_sdk" == Build.PRODUCT || androidId == null
}