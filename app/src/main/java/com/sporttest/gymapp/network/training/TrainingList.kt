package com.sporttest.gymapp.network.training

import com.google.gson.annotations.SerializedName

data class TrainingList(
    @SerializedName("data")
    val data: List<TrainingDto> = emptyList(),
)
