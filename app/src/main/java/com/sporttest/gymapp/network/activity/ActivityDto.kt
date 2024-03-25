package com.sporttest.gymapp.network.activity

import com.google.gson.annotations.SerializedName

data class ActivityDto(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("activityType")
    val activityType: Int? = -1,
    @SerializedName("repetitionsCountMin")
    val repetitionsCountMin: Int? = -1,
    @SerializedName("repetitionsCountMax")
    val repetitionsCountMax: Int? = -1,
    @SerializedName("weight")
    val weight: Double? = 0.0,
    @SerializedName("plannedDuration")
    val plannedDuration: Int? = -1,
    @SerializedName("ownerId")
    val ownerId: Int? = -1,
)
