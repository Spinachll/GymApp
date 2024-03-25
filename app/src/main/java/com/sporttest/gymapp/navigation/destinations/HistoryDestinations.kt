package com.sporttest.gymapp.navigation.destinations

sealed class HistoryDestinations(val route: String) {
    object HistoryRoot : HomeDestinations(route = "HISTORY_ROOT")
    object EditWorkout : HomeDestinations(route = "EDIT_WORKOUT")
    object ListTrainingPlan : HomeDestinations(route = "LIST_TRAINING_PLAN")
    object EditTrainingPlan : HomeDestinations(route = "EDIT_TRAINING_PLAN/{trainingId}")
    object EditExercise : HomeDestinations(route = "EDIT_EXERCISE")
    object EditActivity : HomeDestinations(route = "EDIT_ACTIVITY")
    object ListActivity : HomeDestinations(route = "LIST_ACTIVITY")

    companion object {
        const val NAVIGATION_TRAINING_ID_ARGUMENT = "trainingId"

        fun trainingEditNavigation(trainingId: Int = -1) = "EDIT_TRAINING_PLAN/$trainingId"

    }
}