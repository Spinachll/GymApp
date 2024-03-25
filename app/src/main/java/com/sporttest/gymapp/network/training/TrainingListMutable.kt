package com.sporttest.gymapp.network.training

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.google.gson.annotations.SerializedName

data class TrainingListMutable(
    @SerializedName("id")
    val id: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("userId")
    val userId: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("plannedDuration")
    val plannedDuration: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("exercisesCount")
    val exercisesCount: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("name")
    val name: MutableState<String> = mutableStateOf(""),
    @SerializedName("comment")
    val comment: MutableState<String> = mutableStateOf(""),
)
