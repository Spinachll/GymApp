package com.sporttest.gymapp.repository.training

import com.sporttest.gymapp.network.RetrofitHelper
import com.sporttest.gymapp.network.activity.ActivityDto
import com.sporttest.gymapp.network.activity.ActivityList
import com.sporttest.gymapp.network.training.TrainingDto
import com.sporttest.gymapp.network.training.TrainingList
import retrofit2.Response

class TrainingRepositoryImpl (
    private val api: RetrofitHelper
) : TrainingRepository {
    override suspend fun getTrainingList(token: String): Response<TrainingList> {
        return api.getTrainingList(token = token)
    }

//    override suspend fun editTraining(trainingDto: TrainingDto, token: String): Response<TrainingDto> {
//        return api.editTraining(activityDto = activityDto, token = token)
//    }
}