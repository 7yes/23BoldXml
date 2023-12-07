package com.jess.mbold.ui.model

data class CityForecastItem(
    var city: String,
    var country: String,
    var temToday:Int,
    var temTomorrow:Int,
    var temNextday:Int,
    var climaToday:String,
    var climaTomorrow:String,
    var climaNextday:String,
)