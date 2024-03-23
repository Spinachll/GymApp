package com.sporttest.gymapp.repository.activity

import com.sporttest.gymapp.network.activity.ActivityDto
import com.sporttest.gymapp.network.activity.ActivityList
import retrofit2.Response

interface ActivityRepository {
    suspend fun getActivityList(token: String): Response<ActivityList>
    suspend fun editActivity(activityDto: ActivityDto, token: String): Response<ActivityDto>
}