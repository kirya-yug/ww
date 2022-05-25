package com.example.weatherapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherapp.databinding.WeatherItemBinding
import java.util.zip.Inflater

class WeatherRecyclerAdapter(
    val weathers: List<Weather>
) : RecyclerView.Adapter<WeatherRecyclerAdapter.WeatherRecyclerViewHolder>() {

    class WeatherRecyclerViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(inflater.inflate(R.layout.weather_item, parent, false)) {

        private val binding by viewBinding(WeatherItemBinding::bind)

        fun bind(weather: Weather) {
            binding.textView.text = weather.pressure.toString()
            binding.textView2.text = weather.temp.toString()
            binding.textView3.text = weather.tim.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WeatherRecyclerViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: WeatherRecyclerViewHolder, position: Int) {
        val weather = weathers[position]
        holder.bind(weather)
    }

    override fun getItemCount(): Int = weathers.size
}