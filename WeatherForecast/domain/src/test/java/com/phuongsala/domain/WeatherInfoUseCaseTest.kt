package com.phuongsala.domain

import com.phuongsala.domain.entity.Error
import com.phuongsala.domain.entity.Response
import com.phuongsala.domain.entity.getSampleWeatherInfo
import com.phuongsala.domain.repository.IWeatherInfoRepository
import com.phuongsala.domain.usecase.IWeatherInfoUseCase
import com.phuongsala.domain.usecase.WeatherInfoUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class WeatherInfoUseCaseTest {

    @Mock
    private lateinit var repository: IWeatherInfoRepository

    private lateinit var useCase: IWeatherInfoUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(WeatherInfoUseCaseTest::class)
        useCase = WeatherInfoUseCase(repository)
    }

    @Test
    fun `verify get weather info success`() {
        val city = "saigon"
        runBlockingTest {
            `when`(repository.getWeatherInfo(city)).thenReturn(
                flowOf(Response.Success(listOf(getSampleWeatherInfo())))
            )
            useCase.getWeatherInfo(city).collect {
                assert(it is Response.Success)
                assert((it as Response.Success).data.isNullOrEmpty().not())
            }
        }
    }

    @Test
    fun `verify get weather info failure`() {
        val city = "saigon"
        runBlockingTest {
            `when`(repository.getWeatherInfo(city)).thenReturn(
                flowOf(Response.Failure(Error("not found")))
            )
            useCase.getWeatherInfo(city).collect {
                assert(it is Response.Failure)
                assert((it as Response.Failure).error.message.equals("not found"))
            }
        }
    }

    @Test
    fun `verify invoke remove weather info from local`() {
        runBlockingTest {
            useCase.removeWeatherInfo()
            verify(repository).removeWeatherInfo()
        }
    }

}