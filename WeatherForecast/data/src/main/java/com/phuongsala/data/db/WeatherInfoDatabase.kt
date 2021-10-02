package com.phuongsala.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.phuongsala.data.entity.LocalWeatherInfo

@Database(entities = [LocalWeatherInfo::class], version = 1, exportSchema = false)
abstract class WeatherInfoDatabase : RoomDatabase() {

    abstract fun getWeatherInfoDao(): WeatherInfoDao

    companion object {

        private const val DATABASE_NAME = "WeatherInfo"

        fun build(context: Context): WeatherInfoDatabase {
            return Room.databaseBuilder(context, WeatherInfoDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}