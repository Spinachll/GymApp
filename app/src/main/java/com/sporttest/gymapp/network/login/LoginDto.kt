package com.sporttest.gymapp.network.login

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("login")
    val login: String? = null,

    @SerializedName("password")
    val password: String? = null
)