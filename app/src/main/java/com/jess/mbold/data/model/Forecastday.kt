package com.jess.mbold.data.model

data class Forecastday(
    val date: String,
    val day: Day,
    val hour: List<Hour>
)