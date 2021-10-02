package com.phuongsala.weatherforecast.feature.main.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.phuongsala.domain.entity.Response
import com.phuongsala.domain.entity.WeatherInfo
import com.phuongsala.domain.usecase.IWeatherInfoUseCase
import com.phuongsala.loginexample.common.SingleLiveEvent
import com.phuongsala.weatherforecast.base.BaseViewModel
import com.phuongsala.weatherforecast.common.SecuredSharePreference
import com.phuongsala.weatherforecast.common.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: IWeatherInfoUseCase,
    private val sharedPreferences: SecuredSharePreference
) : BaseViewModel() {

    var getWeatherClick = SingleLiveEvent<Nothing>()
    var state = MutableLiveData<State<List<WeatherInfo>>>()

    fun onButtonClicked() {
        getWeatherClick.call()
    }

    fun getWeatherInfo(cityName: String) {
        state.value = State.Loading(true)
        viewModelScope.launch {
            // remove local data if new date
            if (sharedPreferences.checkIfNewDate()) {
                useCase.removeWeatherInfo()
            }
            // get data
            useCase.getWeatherInfo(cityName)
                .flowOn(Dispatchers.IO)
                .collect {
                    withContext(Dispatchers.Main) {
                        state.value = State.Loading(false)
                        when (it) {
                            is Response.Success<List<WeatherInfo>> -> {
                                state.value = State.Success(it.data)
                            }
                            is Response.Failure -> {
                                state.value = State.Failure(it.error)
                            }
                        }
                    }
                }
        }
    }
}