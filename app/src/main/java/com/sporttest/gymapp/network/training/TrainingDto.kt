package com.sporttest.gymapp.network.training

import com.google.gson.annotations.SerializedName

data class TrainingDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("userId")
    val userId: Int? = null,
    @SerializedName("plannedDuration")
    val plannedDuration: Int? = null,
    @SerializedName("exercisesCount")
    val exercisesCount: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("comment")
    val comment: String? = null,
)
