package com.jess.mbold.data

import com.jess.mbold.data.model.CityResponseItem
import com.jess.mbold.data.model.ForecastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {

    @GET(SEARCH)
    suspend fun getCities(
        @Query("q") city:String,
        @Query("key") apikey:String = API_KEY
    ):Response<ArrayList<CityResponseItem>>

    @GET(PATH)
    suspend fun getForecast(
        @Query("key") apikey:String = API_KEY,
        @Query("q") city:String
        ):Response<ForecastResponse>

    companion object{
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val SEARCH = "search.json"
        const val PATH = "forecast.json"
        const val API_KEY = "de5553176da64306b86153651221606"
    }
}