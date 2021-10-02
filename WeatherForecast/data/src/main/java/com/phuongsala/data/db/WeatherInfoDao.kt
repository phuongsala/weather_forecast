package com.phuongsala.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.phuongsala.data.entity.LocalWeatherInfo

@Dao
interface WeatherInfoDao {

    @Query("SELECT * FROM WeatherInfo WHERE cityName LIKE :cityName")
    suspend fun getWeatherInfo(cityName: String): List<LocalWeatherInfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWeatherInfo(list: List<LocalWeatherInfo>)

    @Query("DELETE FROM WeatherInfo")
    suspend fun removeWeatherInfo()
}