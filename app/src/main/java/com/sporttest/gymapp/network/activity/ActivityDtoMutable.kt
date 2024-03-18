package com.sporttest.gymapp.network.activity

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.google.gson.annotations.SerializedName

data class ActivityDtoMutable(
    @SerializedName("name")
    val name: MutableState<String> = mutableStateOf(""),
    @SerializedName("activityType")
    val activityType: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("repetitionsCountMin")
    val repetitionsCountMin: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("repetitionsCountMax")
    val repetitionsCountMax: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("weight")
    val weight: MutableState<Double> = mutableDoubleStateOf(0.0),
    @SerializedName("plannedDuration")
    val plannedDuration: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("ownerId")
    val ownerId: MutableState<Int> = mutableIntStateOf(-1),
)
