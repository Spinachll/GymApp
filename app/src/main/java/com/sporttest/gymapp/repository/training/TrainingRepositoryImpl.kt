package com.sporttest.gymapp.repository.training

import com.sporttest.gymapp.network.RetrofitHelper
import com.sporttest.gymapp.network.activity.ActivityDto
import com.sporttest.gymapp.network.activity.ActivityList
import com.sporttest.gymapp.network.training.TrainingDto
import com.sporttest.gymapp.network.training.TrainingGetDetailsDto
import com.sporttest.gymapp.network.training.TrainingList
import retrofit2.Response

class TrainingRepositoryImpl(
    private val api: RetrofitHelper
) : TrainingRepository {
    override suspend fun getTrainingList(token: String): Response<TrainingList> {
        return api.getTrainingList(token = token)
    }

    override suspend fun getTrainingDetails(trainingId: Int, token: String): Response<TrainingDto> {
        return api.getTrainingDetails(
            trainingDetails = TrainingGetDetailsDto(trainingId),
            token = token
        )
    }

    override suspend fun updateTraining(trainingDto: TrainingDto, token: String): Response<TrainingDto> {
        return api.updateTraining(trainingDto = trainingDto, token = token)
    }
}