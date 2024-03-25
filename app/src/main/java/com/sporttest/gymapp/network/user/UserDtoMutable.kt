package com.sporttest.gymapp.network.user

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.google.gson.annotations.SerializedName

data class UserDtoMutable(
    @SerializedName("name")
    val name: MutableState<String?> = mutableStateOf(null),
    @SerializedName("surname")
    val surname: MutableState<String?> = mutableStateOf(null),
    @SerializedName("patronymic")
    val patronymic: MutableState<String?> = mutableStateOf(null),
    @SerializedName("age")
    val age: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("weight")
    val weight: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("height")
    val height: MutableState<Int?> = mutableStateOf(null),
    @SerializedName("email")
    val email: MutableState<String?> = mutableStateOf(null),
    @SerializedName("login")
    val login: MutableState<String?> = mutableStateOf(null),
    @SerializedName("password")
    val password: MutableState<String?> = mutableStateOf(null),
)
