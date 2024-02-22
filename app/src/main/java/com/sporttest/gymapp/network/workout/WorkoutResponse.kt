package com.sporttest.gymapp.network.workout

import com.google.gson.annotations.SerializedName

data class WorkoutResponse(
    @SerializedName("data")
    val workoutItems: List<WorkoutDto>,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total")
    val total: Int
)