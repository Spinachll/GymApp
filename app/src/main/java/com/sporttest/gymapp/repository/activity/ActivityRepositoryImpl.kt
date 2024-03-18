package com.sporttest.gymapp.repository.activity

import com.sporttest.gymapp.network.RetrofitHelper
import com.sporttest.gymapp.network.activity.ActivityDto
import retrofit2.Response

class ActivityRepositoryImpl (
    private val api: RetrofitHelper
) : ActivityRepository {
    override suspend fun editActivity(activityDto: ActivityDto, token: String): Response<ActivityDto> {
        return api.editActivity(activityDto = activityDto, token = token)
    }
}