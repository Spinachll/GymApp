package com.sporttest.gymapp.repository.login

import com.sporttest.gymapp.network.login.LoginDto
import com.sporttest.gymapp.network.login.TokenDto
import com.sporttest.gymapp.network.user.RegisterDto
import com.sporttest.gymapp.network.user.UserDto
import retrofit2.Response

interface LoginRepository {
    suspend fun login(loginDto: LoginDto): Response<TokenDto>

    suspend fun register(userDto: UserDto): Response<RegisterDto>
}