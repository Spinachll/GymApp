package com.sporttest.gymapp.navigation.destinations

sealed class HistoryDestinations (val route: String) {
    object HistoryRoot : HomeDestinations(route = "HISTORY_ROOT")
    object AddWorkout : HomeDestinations(route = "ADD_WORKOUT")
}