package com.jess.mbold.data

import com.jess.mbold.data.model.CityResponseItem
import com.jess.mbold.data.model.ForecastResponse
import retrofit2.http.GET
import javax.inject.Inject

class CityService @Inject constructor(private val api:CityApi) {

    @GET
    suspend fun getCities(city: String): ArrayList<CityResponseItem>? {
         val response = api.getCities(city)
        return response.body()
    }

    @GET
    suspend fun getForecast(city: String): ForecastResponse? {
        val response = api.getForecast(city = city)
        return response.body()
    }
}