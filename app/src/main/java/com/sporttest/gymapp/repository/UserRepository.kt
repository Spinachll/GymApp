package com.sporttest.gymapp.repository

import com.sporttest.gymapp.network.UsersResponse

interface UserRepository {

    suspend fun getUsers(page: Int, limit: Int): UsersResponse

}