package com.sporttest.gymapp.repository.login

import android.util.Log
import com.sporttest.gymapp.network.RetrofitHelper
import com.sporttest.gymapp.network.login.LoginDto
import com.sporttest.gymapp.network.login.TokenDto
import com.sporttest.gymapp.network.user.RegisterDto
import com.sporttest.gymapp.network.user.UserDto
import com.sporttest.gymapp.network.workout.WorkoutResponse
import com.sporttest.gymapp.repository.workout.WorkoutRepository
import retrofit2.Response

class LoginRepositoryImpl(
    private val api: RetrofitHelper
) : LoginRepository {

    override suspend fun login(loginDto: LoginDto): Response<TokenDto> {
        return api.login(loginDto = loginDto)
    }

    override suspend fun register(userDto: UserDto): Response<RegisterDto> {
        return api.register(userDto = userDto)
    }
}