package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {

    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        viewModel.weatherListLiveData.observe(this){
            findViewById<RecyclerView>(R.id.rcv).adapter = WeatherRecyclerAdapter(it)
            findViewById<RecyclerView>(R.id.rcv).adapter?.notifyDataSetChanged()
        }
        viewModel.getAllWeather()
    }
}