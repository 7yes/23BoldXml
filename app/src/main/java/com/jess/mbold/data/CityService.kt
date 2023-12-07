package com.jess.mbold.data

import com.jess.mbold.data.model.CityResponseItem
import retrofit2.http.GET
import javax.inject.Inject

class CityService @Inject constructor(private val api:CityApi) {

    @GET
    suspend fun getCities(city: String): ArrayList<CityResponseItem>? {
         val response = api.getCities(city)
        return response.body()
    }
}