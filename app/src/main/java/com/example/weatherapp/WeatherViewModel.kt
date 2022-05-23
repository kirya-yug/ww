package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherDao: WeatherDao
): ViewModel(){
    private val _weatherListLiveData: MutableLiveData<List<Weather>> = MutableLiveData()
    val weatherListLiveData: LiveData<List<Weather>> = _weatherListLiveData

    @SuppressLint("CheckResult")
    fun getAllWeather() {
        weatherDao.getAllWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _weatherListLiveData.value = it
            }, {

            })
    }

    @SuppressLint("CheckResult")
    fun saveWeather(weather: Weather) {
        Single.just(weather)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                weatherDao.insertWeather(it)
            }, {

            })
    }
}