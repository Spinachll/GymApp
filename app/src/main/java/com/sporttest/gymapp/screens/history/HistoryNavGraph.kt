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
        startDestination = HistoryDestinations.AddWorkout.route
    ) {
        composable(route = HistoryDestinations.AddWorkout.route) {
            AddWorkoutScreen(
                navController = navController,
                homeViewModel = homeViewModel)
        }
    }
}