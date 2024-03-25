package com.sporttest.gymapp.screens.history

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
                homeViewModel = homeViewModel
            )
        }

        composable(route = HistoryDestinations.ListTrainingPlan.route) {
            ListTrainingScreen(
                navController = navController,
                homeViewModel = homeViewModel
            )
        }

        composable(
            route = HistoryDestinations.EditTrainingPlan.route,
            arguments = listOf(navArgument(HistoryDestinations.NAVIGATION_TRAINING_ID_ARGUMENT) {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            navBackStackEntry
                .arguments?.getInt(HistoryDestinations.NAVIGATION_TRAINING_ID_ARGUMENT)
                ?.let { trainingId ->
                    EditTrainingPlanScreen(
                        trainingId = trainingId,
                        navController = navController,
                        homeViewModel = homeViewModel
                    )
                }
        }

        composable(route = HistoryDestinations.EditExercise.route) {
            EditExerciseScreen(
                navController = navController,
                homeViewModel = homeViewModel
            )
        }

        composable(route = HistoryDestinations.ListActivity.route) {
            ListActivityScreen(
                navController = navController,
                homeViewModel = homeViewModel
            )
        }

        composable(route = HistoryDestinations.EditActivity.route) {
            EditActivityScreen(
                navController = navController,
                homeViewModel = homeViewModel
            )
        }
    }
}