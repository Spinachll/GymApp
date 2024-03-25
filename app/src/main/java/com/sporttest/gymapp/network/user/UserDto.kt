package com.sporttest.gymapp.network.user

import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("surname")
    val surname: String? = null,
    @SerializedName("patronymic")
    val patronymic: String? = null,
    @SerializedName("age")
    val age: Int? = null,
    @SerializedName("weight")
    val weight: Int? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("login")
    val login: String? = null,
    @SerializedName("password")
    val password: String? = null,
)
