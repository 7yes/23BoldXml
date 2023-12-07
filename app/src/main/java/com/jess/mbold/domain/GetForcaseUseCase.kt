package com.jess.mbold.domain

import com.jess.mbold.data.WeatherRepo
import com.jess.mbold.data.model.ForecastResponse
import javax.inject.Inject

class GetForcaseUseCase @Inject constructor(private  val repo: WeatherRepo) {

    suspend fun getForecast(city:String): ForecastResponse? {
        return repo.getForecast(city)
    }
}