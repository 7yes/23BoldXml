package com.jess.mbold.data

import com.jess.mbold.data.model.CityResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {

    @GET(PATH)
    suspend fun getCities(
        @Query("q") city:String,
        @Query("key") apikey:String = API_KEY
    ):Response<ArrayList<CityResponseItem>>

    companion object{
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val PATH = "search.json"
        const val API_KEY = "de5553176da64306b86153651221606"
    }
}