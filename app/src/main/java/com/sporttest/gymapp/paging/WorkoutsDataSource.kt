package com.sporttest.gymapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sporttest.gymapp.network.workout.WorkoutDto
import com.sporttest.gymapp.repository.workout.WorkoutRepository

class WorkoutsDataSource(
    private val repo: WorkoutRepository
): PagingSource<Int, WorkoutDto>() {

    override fun getRefreshKey(state: PagingState<Int, WorkoutDto>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    //TODO Find out how this shit work, rebuild nextKey in load()
    override val keyReuseSupported: Boolean
        get() = true

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, WorkoutDto> {
        return try {
            val page = params.key ?: 1
            val response = repo.getWorkouts(page, 10)
            LoadResult.Page(
                data = response.workoutItems,
                prevKey = null,
                nextKey = if (response.workoutItems.isNotEmpty()) response.page + 1 else null
            )
        } catch (e: Exception) {
            println("ERROR HERE")
            LoadResult.Error(e)
        }
    }
}