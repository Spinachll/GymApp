package com.sporttest.gymapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.sporttest.gymapp.paging.WorkoutsDataSource
import com.sporttest.gymapp.repository.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: WorkoutRepository
) : ViewModel() {

    val usersPager = Pager(
        PagingConfig(pageSize = 10)
    ) {
        WorkoutsDataSource(repo)
    }.flow.cachedIn(viewModelScope)

}