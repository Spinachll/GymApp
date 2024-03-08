package com.sporttest.gymapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.sporttest.gymapp.data.datastore.AppValuesStore
import com.sporttest.gymapp.paging.WorkoutsDataSource
import com.sporttest.gymapp.repository.workout.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: WorkoutRepository
) : AndroidViewModel(Application()) {

    var logoutProcess: Boolean = false

    val activityPager = Pager(
        PagingConfig(pageSize = 10)
    ) {
        val ds = AppValuesStore(Application())
        WorkoutsDataSource(repo, ds)
    }.flow.cachedIn(viewModelScope)

}