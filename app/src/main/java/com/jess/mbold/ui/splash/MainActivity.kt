package com.jess.mbold.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jess.mbold.databinding.ActivityMainBinding
import com.jess.mbold.ui.weather.WeatherActivity
import com.jess.mbold.ui.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val screenSplash = installSplashScreen()
        setContentView ( binding.root )

        viewModel.showSplash.observe(this) {
            when (it) {
                true -> screenSplash.setKeepOnScreenCondition { it }
                false -> {
                    val intent = Intent(this, WeatherActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        viewModel.getInitialData()
    }
}