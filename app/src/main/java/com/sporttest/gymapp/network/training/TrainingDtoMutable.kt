package com.sporttest.gymapp.network.training

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.google.gson.annotations.SerializedName

data class TrainingDtoMutable(
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
) {
    constructor(trainingDto: TrainingDto): this() {
        this.id.value = trainingDto.id?:-1
        this.userId.value = trainingDto.userId?:-1
        this.plannedDuration.value = trainingDto.plannedDuration?:-1
        this.exercisesCount.value = trainingDto.exercisesCount?:-1
        this.name.value = trainingDto.name?:""
        this.comment.value = trainingDto.comment?:""
    }

}
