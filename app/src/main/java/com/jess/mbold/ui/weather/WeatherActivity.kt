package com.jess.mbold.ui.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jess.mbold.R
import com.jess.mbold.databinding.ActivityWeatherBinding
import com.jess.mbold.ui.weather.weathercity.CityFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {
private lateinit var binding: ActivityWeatherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)

        setContentView ( binding.root )

        supportFragmentManager.beginTransaction().add(R.id.frag_container,CityFragment()).commit()
    }
}