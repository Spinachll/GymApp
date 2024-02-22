package com.sporttest.gymapp.network.login

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("token")
    val sessionToken: String
)
