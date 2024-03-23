package com.sporttest.gymapp.network.activity

import com.google.gson.annotations.SerializedName

data class ActivityList(
    @SerializedName("data")
    val data: List<ActivityDto> = emptyList(),
)
