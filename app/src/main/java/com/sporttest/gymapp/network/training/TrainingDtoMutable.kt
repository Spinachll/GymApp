package com.sporttest.gymapp.network.training

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.google.gson.annotations.SerializedName

data class TrainingDtoMutable(
    @SerializedName("id")
    val id: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("userId")
    val userId: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("plannedDuration")
    val plannedDuration: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("exercisesCount")
    val exercisesCount: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("name")
    val name: MutableState<String?> = mutableStateOf(null),
    @SerializedName("comment")
    val comment: MutableState<String?> = mutableStateOf(null),
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
