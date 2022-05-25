package com.example.weatherapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Weather::class], version = 2)
abstract class WeatherDB: RoomDatabase() {
    abstract fun getWeatherDao(): WeatherDao
}