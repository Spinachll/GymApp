package com.sporttest.gymapp.repository

import com.sporttest.gymapp.network.WorkoutResponse

interface WorkoutRepository {

    suspend fun getWorkouts(page: Int, limit: Int): WorkoutResponse

}