package com.sporttest.gymapp.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.sporttest.gymapp.data.datastore.AppValuesStore
import com.sporttest.gymapp.network.activity.ActivityDto
import com.sporttest.gymapp.network.activity.ActivityDtoMutable
import com.sporttest.gymapp.network.training.TrainingDto
import com.sporttest.gymapp.paging.WorkoutsDataSource
import com.sporttest.gymapp.repository.activity.ActivityRepository
import com.sporttest.gymapp.repository.training.TrainingRepository
import com.sporttest.gymapp.repository.workout.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val workoutRepository: WorkoutRepository,
    private val activityRepository: ActivityRepository,
    private val trainingRepository: TrainingRepository

) : AndroidViewModel(Application()) {

    var errorMessage: String by mutableStateOf("")

    //Training
    private val _trainingList = mutableStateListOf<TrainingDto>()
    val trainingList: List<TrainingDto>
        get() = _trainingList

    //Activities
    private val _activityList = mutableStateListOf<ActivityDto>()
    val activityList: List<ActivityDto>
        get() = _activityList
    val editActivity = mutableStateOf(value = ActivityDtoMutable())

    var logoutProcess: Boolean = false

    val activityPager = Pager(
        PagingConfig(pageSize = 10)
    ) {
        val ds = AppValuesStore(Application())
        WorkoutsDataSource(workoutRepository, ds)
    }.flow.cachedIn(viewModelScope)


    //Training plans
    fun getTrainingList(context: Context) {
        viewModelScope.launch {
            try {
                val dataStore = AppValuesStore(context)
                val userToken = dataStore.getUserToken.first()

                val response = trainingRepository.getTrainingList(
                    userToken ?: ""
                )

                if (response.isSuccessful) {
                    println("Get trainings list is good")
                    response.body()?.let { trainingList ->
                        Log.d("Edit Activity", "Response TrainingDto: $trainingList")
                        _trainingList.clear()
                        _trainingList.addAll(trainingList.data)
                    }
                    println(_trainingList.toList())

                } else {
                    println("Get Training is bad")
                }
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
            }
        }
    }


    //Activities
    fun getActivityList(context: Context) {
        viewModelScope.launch {
            try {
                val dataStore = AppValuesStore(context)
                val userToken = dataStore.getUserToken.first()

                val response = activityRepository.getActivityList(
                    userToken ?: ""
                )

                if (response.isSuccessful) {
                    println("Get activities list is good")
                    response.body()?.let { activityDto ->
                        Log.d("Edit Activity", "Response ActivityDto: $activityDto")
                        _activityList.clear()
                        _activityList.addAll(activityDto.data)
                    }
                    println(_activityList.toList())
                } else {
                    println("Register is bad")
                }
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
            }
        }
    }

    fun editActivity(activityDto: ActivityDto, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val dataStore = AppValuesStore(context)
                val userToken = dataStore.getUserToken.first()

                val response = activityRepository.editActivity(
                    activityDto,
                    userToken ?: ""
                )

                if (response.isSuccessful) {
                    println("Create activity is good")
                    response.body()?.let { activityDto ->
                        Log.d("Edit Activity", "Response ActivityDto: $activityDto")
                    }
                } else {
                    println("Register is bad")
                }
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
            }
        }
    }

}