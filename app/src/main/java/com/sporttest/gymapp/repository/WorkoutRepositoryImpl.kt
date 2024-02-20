package com.sporttest.gymapp.repository

import com.sporttest.gymapp.network.WorkoutApi
import com.sporttest.gymapp.network.WorkoutResponse

class WorkoutRepositoryImpl(
    private val api: WorkoutApi
) : WorkoutRepository {

    override suspend fun getWorkouts(page: Int, limit: Int): WorkoutResponse {
        return api.getWorkouts(page, limit)
    }
}