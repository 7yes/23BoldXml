package com.jess.mbold.data.model

data class ForecastResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)