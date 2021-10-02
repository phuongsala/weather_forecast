package com.phuongsala.weatherforecast.feature.main.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.phuongsala.domain.entity.WeatherInfo
import com.phuongsala.weatherforecast.R
import com.phuongsala.weatherforecast.base.BaseActivity
import com.phuongsala.weatherforecast.common.State
import com.phuongsala.weatherforecast.common.checkIfDeviceWasRooted
import com.phuongsala.weatherforecast.common.hideKeyboard
import com.phuongsala.weatherforecast.common.toast
import com.phuongsala.weatherforecast.databinding.ActivityMainBinding
import com.phuongsala.weatherforecast.feature.main.model.WeatherInfoModel
import com.phuongsala.weatherforecast.feature.main.view.adapter.MainAdapter
import com.phuongsala.weatherforecast.feature.main.viewmodel.MainViewModel
import com.phuongsala.weatherforecast.mapper.toWeatherInfoModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private var weatherAdapter = MainAdapter()

    override val layoutId: Int = R.layout.activity_main

    override fun setBindingVariables() {
        super.setBindingVariables()
        viewDataBinding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (checkIfDeviceWasRooted()) {
            toast(getString(R.string.txt_not_support_rooted_device))
            return
        }
    }

    override fun initViews() {
        super.initViews()
        viewDataBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = weatherAdapter
        }
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.getWeatherClick.observe(this, {
            val input = viewDataBinding.inputCity.text?.toString()
            if (!input.isNullOrEmpty() && input.length >= 3) {
                getData(input.toString())
                hideKeyboard(viewDataBinding.inputCity)
            } else {
                toast(getString(R.string.txt_input_at_least_three_characters))
            }
        })
        viewModel.state.observe(this, {
            when (it) {
                is State.Loading -> {
                    viewDataBinding.progressBar.visibility = View.VISIBLE
                }
                is State.Success<List<WeatherInfo>> -> {
                    viewDataBinding.progressBar.visibility = View.GONE
                    val list: List<WeatherInfoModel> =
                        it.data.map { obj -> obj.toWeatherInfoModel() }
                    weatherAdapter.setData(list)
                }
                is State.Failure -> {
                    viewDataBinding.progressBar.visibility = View.GONE
                    it.error.message?.let { msg -> toast(msg) }
                }
            }
        })
    }

    private fun getData(cityName: String) {
        viewModel.getWeatherInfo(cityName)
    }

}