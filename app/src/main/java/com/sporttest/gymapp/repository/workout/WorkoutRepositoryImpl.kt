package com.sporttest.gymapp.repository.workout

import com.sporttest.gymapp.network.RetrofitHelper
import com.sporttest.gymapp.network.workout.WorkoutResponse

class WorkoutRepositoryImpl(
    private val api: RetrofitHelper
) : WorkoutRepository {

    override suspend fun getWorkouts(page: Int, limit: Int, token: String): WorkoutResponse {
        return api.getWorkouts(page, limit, token)
    }
}