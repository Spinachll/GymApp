package com.sporttest.gymapp.network.user

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class RegisterDto(
    @SerializedName("message")
    val sessionToken: String,
    @SerializedName("errors")
    val errors: JsonObject
)
