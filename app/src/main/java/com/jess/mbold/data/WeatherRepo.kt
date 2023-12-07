package com.jess.mbold.data

import com.jess.mbold.data.model.CityResponseItem
import javax.inject.Inject

class WeatherRepo @Inject constructor(private val cityService: CityService) {
    suspend fun getCities(city: String): ArrayList<CityResponseItem>? {
        return cityService.getCities(city)
    }
}