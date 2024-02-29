package com.sporttest.gymapp.network.user

import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("surname")
    val surname: String = "",
    @SerializedName("patronymic")
    val patronymic: String = "",
    @SerializedName("age")
    val age: Int = -1,
    @SerializedName("weight")
    val weight: Int = -1,
    @SerializedName("height")
    val height: Int = -1,
    @SerializedName("email")
    val email: String = "",
    @SerializedName("login")
    val login: String = "",
    @SerializedName("password")
    val password: String = "",
)
