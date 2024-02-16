package com.sporttest.gymapp.repository

import com.sporttest.gymapp.network.UsersApi
import com.sporttest.gymapp.network.UsersResponse

class UserRepositoryImpl(
    private val api: UsersApi
) : UserRepository {

    override suspend fun getUsers(page: Int, limit: Int): UsersResponse {
        return api.getUsers(page, limit)
    }
}