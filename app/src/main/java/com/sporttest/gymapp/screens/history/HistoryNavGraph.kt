package com.sporttest.gymapp.screens.history

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sporttest.gymapp.navigation.destinations.HistoryDestinations
import com.sporttest.gymapp.viewmodel.HomeViewModel

fun NavGraphBuilder.historyNavGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    navigation(
        route = HistoryDestinations.HistoryRoot.route,
        startDestination = HistoryDestinations.EditWorkout.route
    ) {
        composable(route = HistoryDestinations.EditWorkout.route) {
            EditWorkoutScreen(
                navController = navController,
                homeViewModel = homeViewModel)
        }

        composable(route = HistoryDestinations.EditTrainingPlan.route) {
            EditTrainingPlanScreen(
                navController = navController,
                homeViewModel = homeViewModel)
        }

        composable(route = HistoryDestinations.EditExercise.route) {
            EditExerciseScreen(
                navController = navController,
                homeViewModel = homeViewModel)
        }

        composable(route = HistoryDestinations.ListActivity.route) {
            ListActivityScreen(
                navController = navController,
                homeViewModel = homeViewModel)
        }

        composable(route = HistoryDestinations.EditActivity.route) {
            EditActivityScreen(
                navController = navController,
                homeViewModel = homeViewModel)
        }
    }
}