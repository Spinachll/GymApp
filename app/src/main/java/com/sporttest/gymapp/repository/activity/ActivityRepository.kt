package com.sporttest.gymapp.repository.activity

import com.sporttest.gymapp.network.activity.ActivityDto
import retrofit2.Response

interface ActivityRepository {
    suspend fun editActivity(activityDto: ActivityDto, token: String): Response<ActivityDto>
}