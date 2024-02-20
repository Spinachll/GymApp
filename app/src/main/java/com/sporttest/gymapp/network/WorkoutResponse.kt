package com.sporttest.gymapp.network

import com.squareup.moshi.Json

data class WorkoutResponse(
    @field:Json(name = "data")
    val workoutItems: List<WorkoutItem>,
    @field:Json(name = "limit")
    val limit: Int,
    @field:Json(name = "page")
    val page: Int,
    @field:Json(name = "total")
    val total: Int
)