package com.sporttest.gymapp.repository.training

import com.sporttest.gymapp.network.training.TrainingDto
import com.sporttest.gymapp.network.training.TrainingList
import retrofit2.Response

interface TrainingRepository {
    suspend fun getTrainingList(token: String): Response<TrainingList>

    suspend fun getTrainingDetails(trainingId: Int, token: String): Response<TrainingDto>

    suspend fun updateTraining(trainingDto: TrainingDto, token: String): Response<TrainingDto>
}