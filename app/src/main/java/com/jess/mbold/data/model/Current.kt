package com.jess.mbold.data.model

data class Current(
    val cloud: Int,
    val condition: Condition,
    val temp_c: Double,
    val uv: Double,
   )