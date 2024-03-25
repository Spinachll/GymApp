package com.sporttest.gymapp.repository.training

import com.sporttest.gymapp.network.training.TrainingDto
import com.sporttest.gymapp.network.training.TrainingList
import retrofit2.Response

interface TrainingRepository {
    suspend fun getTrainingList(token: String): Response<TrainingList>
    //suspend fun editTraining(trainingDto: TrainingDto, token: String): Response<TrainingDto>
}