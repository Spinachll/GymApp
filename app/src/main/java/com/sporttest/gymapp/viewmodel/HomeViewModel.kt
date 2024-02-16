package com.sporttest.gymapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.sporttest.gymapp.paging.UsersDataSource
import com.sporttest.gymapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {

    val usersPager = Pager(
        PagingConfig(pageSize = 10)
    ) {
        UsersDataSource(repo)
    }.flow.cachedIn(viewModelScope)

}