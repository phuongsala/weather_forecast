package com.phuongsala.presentation.common

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.util.*
import javax.inject.Inject

class SecuredSharePreference @Inject constructor(private val context: Context) {

    private fun getSharedPreferences(): SharedPreferences {
        return EncryptedSharedPreferences.create(
            context,
            SECRET_SHARED_PREFERENCES,
            createOrGetMasterKeys(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    private fun createOrGetMasterKeys(): MasterKey {
        return MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
    }

    fun checkIfNewDate(): Boolean {
        val preDate = getSharedPreferences().getLong(TIME_REQUEST, 0)
        val curDate = Calendar.getInstance().apply {
            set(Calendar.HOUR, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis
        saveRequestTime(curDate)
        return curDate > preDate
    }

    private fun saveRequestTime(time: Long) {
        getSharedPreferences().edit().putLong(TIME_REQUEST, time).apply()
    }

    companion object {
        private const val SECRET_SHARED_PREFERENCES = "SECRET_SHARED_PREFERENCES"
        private const val TIME_REQUEST = "TIME_REQUEST"
    }

}