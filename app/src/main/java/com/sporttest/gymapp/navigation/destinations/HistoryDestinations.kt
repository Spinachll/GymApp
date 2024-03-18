package com.sporttest.gymapp.navigation.destinations

sealed class HistoryDestinations(val route: String) {
    object HistoryRoot : HomeDestinations(route = "HISTORY_ROOT")
    object EditWorkout : HomeDestinations(route = "EDIT_WORKOUT")
    object EditTrainingPlan : HomeDestinations(route = "EDIT_TRAINING_PLAN")
    object EditExercise : HomeDestinations(route = "EDIT_EXERCISE")
    object EditActivity : HomeDestinations(route = "EDIT_ACTIVITY")
}