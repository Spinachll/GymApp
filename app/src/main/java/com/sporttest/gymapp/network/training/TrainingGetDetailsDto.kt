package com.sporttest.gymapp.network.training

import com.google.gson.annotations.SerializedName

data class TrainingGetDetailsDto(
    @SerializedName("trainingId")
    val id: Int? = -1
)
