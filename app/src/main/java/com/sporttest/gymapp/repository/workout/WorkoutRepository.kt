package com.sporttest.gymapp.repository.workout

import com.sporttest.gymapp.network.workout.WorkoutResponse

interface WorkoutRepository {

    suspend fun getWorkouts(page: Int, limit: Int): WorkoutResponse

}