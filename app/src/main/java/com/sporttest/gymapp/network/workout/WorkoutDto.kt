package com.sporttest.gymapp.network.workout

import com.google.gson.annotations.SerializedName

data class WorkoutDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("exercisesCount")
    val exercisesCount: Int,
    @SerializedName("spentTime")
    val spentTime: Int,
    @SerializedName("localDateTime")
    val localDateTime: String,
    @SerializedName("unixTime")
    val unixTime: Long
)
