package com.sporttest.gymapp.network.training

import com.google.gson.annotations.SerializedName

data class TrainingDto(
    @SerializedName("id")
    val id: Int? = -1,
    @SerializedName("userId")
    val userId: Int? = -1,
    @SerializedName("plannedDuration")
    val plannedDuration: Int? = -1,
    @SerializedName("exercisesCount")
    val exercisesCount: Int? = -1,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("comment")
    val comment: String? = "",
)
