package com.example.weatherapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Weather(
    @PrimaryKey(autoGenerate = true)val id: Int = 0,
    val temp: String,
    val pressure: String
)
