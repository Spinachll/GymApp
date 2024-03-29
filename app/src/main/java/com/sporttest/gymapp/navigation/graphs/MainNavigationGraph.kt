package com.sporttest.gymapp.navigation.graphs

import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sporttest.gymapp.navigation.destinations.BottomBarDestinations
import com.sporttest.gymapp.screens.components.BottomBar
import com.sporttest.gymapp.screens.exercise.ExerciseScreen
import com.sporttest.gymapp.screens.history.HistoryScreen
import com.sporttest.gymapp.screens.home.HomeScreen
import com.sporttest.gymapp.screens.home.homeNavGraph
import com.sporttest.gymapp.screens.nutrition.NutritionScreen

@Composable
fun MainNavigationGraph(
    navController: NavHostController
) {
    val scaffoldState = rememberScaffoldState()

    androidx.compose.material.Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            route = Graph.MAIN,
            startDestination = BottomBarDestinations.Home.route
        ) {
            composable(route = BottomBarDestinations.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(route = BottomBarDestinations.History.route) {
                HistoryScreen(navController = navController)
            }
            composable(route = BottomBarDestinations.Exercise.route) {
                ExerciseScreen(navController = navController)
            }
            composable(route = BottomBarDestinations.Nutrition.route) {
                NutritionScreen(navController = navController)
            }
            homeNavGraph(navController = navController)
        }
    }
}