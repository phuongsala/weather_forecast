package com.phuongsala.data

import android.accounts.NetworkErrorException
import com.google.gson.Gson
import com.phuongsala.data.api.ApiService
import com.phuongsala.data.db.WeatherInfoDao
import com.phuongsala.data.db.WeatherInfoDatabase
import com.phuongsala.data.entity.*
import com.phuongsala.data.repository.WeatherInfoRepository
import com.phuongsala.domain.entity.Response
import com.phuongsala.domain.repository.IWeatherInfoRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class WeatherInfoRepositoryTest {

    @Mock
    private lateinit var apiService: ApiService

    @Mock
    private lateinit var database: WeatherInfoDatabase

    private lateinit var repository: IWeatherInfoRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(WeatherInfoRepositoryTest::class)
        repository = WeatherInfoRepository(apiService, database)
        `when`(database.getWeatherInfoDao()).thenReturn(mock(WeatherInfoDao::class.java))
    }

    @Test
    fun `verify invoke get data from database success`() {
        runBlockingTest {
            val city = "saigon"
            `when`(database.getWeatherInfoDao().getWeatherInfo(city))
                .thenReturn(listOf(getSampleLocalWeatherInfo()))
            repository.getWeatherInfo(city).collect {
                assert(it is Response.Success)
                assert((it as Response.Success).data.isNullOrEmpty().not())
            }
        }
    }

    @Test
    fun `verify invoke get data from remote success`() {
        runBlockingTest {
            val city = "saigon"
            `when`(database.getWeatherInfoDao().getWeatherInfo(city))
                .thenReturn(listOf())
            `when`(
                apiService.getWeatherForecast(
                    query = city,
                    count = 7,
                    appId = BuildConfig.APP_ID,
                    units = TempUnit.CELSIUS.value
                )
            ).thenReturn(
                Gson().fromJson(
                    getSampleWeatherForecastResponse(),
                    WeatherForecastResponse::class.java
                )
            )
            repository.getWeatherInfo(city).collect {
                assert(it is Response.Success)
                assert((it as Response.Success).data.size == 7)
            }
        }
    }

    @Test
    fun `verify invoke get data failure`() {
        runBlockingTest {
            val city = "saigon"
            `when`(database.getWeatherInfoDao().getWeatherInfo(city))
                .thenReturn(listOf())
            `when`(
                apiService.getWeatherForecast(
                    query = city,
                    count = 7,
                    appId = BuildConfig.APP_ID,
                    units = TempUnit.CELSIUS.value
                )
            ).thenAnswer { throw NetworkErrorException() }

            repository.getWeatherInfo(city).collect {
                assert(it is Response.Failure)
                assert((it as Response.Failure).error.message.isNullOrEmpty().not())
            }
        }
    }

}