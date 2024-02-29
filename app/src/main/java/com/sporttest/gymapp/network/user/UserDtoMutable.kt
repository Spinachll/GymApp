package com.sporttest.gymapp.network.user

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.google.gson.annotations.SerializedName

data class UserDtoMutable(
    @SerializedName("name")
    val name: MutableState<String> = mutableStateOf(""),
    @SerializedName("surname")
    val surname: MutableState<String> = mutableStateOf(""),
    @SerializedName("patronymic")
    val patronymic: MutableState<String> = mutableStateOf(""),
    @SerializedName("age")
    val age: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("weight")
    val weight: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("height")
    val height: MutableState<Int> = mutableIntStateOf(-1),
    @SerializedName("email")
    val email: MutableState<String> = mutableStateOf(""),
    @SerializedName("login")
    val login: MutableState<String> = mutableStateOf(""),
    @SerializedName("password")
    val password: MutableState<String> = mutableStateOf(""),
)
