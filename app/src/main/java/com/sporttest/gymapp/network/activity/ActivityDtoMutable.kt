package com.sporttest.gymapp.network.activity

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.google.gson.annotations.SerializedName

data class ActivityDtoMutable(
    @SerializedName("name")
    val name: MutableState<String?> = mutableStateOf(null),
    @SerializedName("activityType")
    val activityType: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("repetitionsCountMin")
    val repetitionsCountMin: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("repetitionsCountMax")
    val repetitionsCountMax: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("weight")
    val weight: MutableState<Double?> = mutableStateOf(null),
    @SerializedName("plannedDuration")
    val plannedDuration: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("ownerId")
    val ownerId: MutableState<Int?> = mutableStateOf(null),
)
