package com.sporttest.gymapp.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.sporttest.gymapp.data.datastore.AppValuesStore
import com.sporttest.gymapp.network.activity.ActivityDto
import com.sporttest.gymapp.network.activity.ActivityDtoMutable
import com.sporttest.gymapp.paging.WorkoutsDataSource
import com.sporttest.gymapp.repository.activity.ActivityRepository
import com.sporttest.gymapp.repository.workout.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val workoutRepository: WorkoutRepository,
    private val activityRepository: ActivityRepository

) : AndroidViewModel(Application()) {

    val editActivity = mutableStateOf(value = ActivityDtoMutable())

    var logoutProcess: Boolean = false

    val activityPager = Pager(
        PagingConfig(pageSize = 10)
    ) {
        val ds = AppValuesStore(Application())
        WorkoutsDataSource(workoutRepository, ds)
    }.flow.cachedIn(viewModelScope)

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