package com.sporttest.gymapp.network

import com.squareup.moshi.Json

data class WorkoutItem(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "exercisesCount")
    val exercisesCount: Int,
    @field:Json(name = "spentTime")
    val spentTime: Int,
    @field:Json(name = "localDateTime")
    val localDateTime: String,
    @field:Json(name = "unixTime")
    val unixTime: Long
)
