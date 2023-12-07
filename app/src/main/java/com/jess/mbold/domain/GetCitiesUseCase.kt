package com.jess.mbold.domain

import com.jess.mbold.data.WeatherRepo
import com.jess.mbold.data.model.CityResponseItem
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(private val repo: WeatherRepo) {

    suspend fun getCities(city:String):ArrayList<CityResponseItem>?{
        return repo.getCities(city)
    }
}