package com.sporttest.gymapp.navigation.graphs

import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sporttest.gymapp.navigation.destinations.BottomBarDestinations
import com.sporttest.gymapp.navigation.destinations.HistoryDestinations
import com.sporttest.gymapp.screens.components.BottomBar
import com.sporttest.gymapp.screens.components.TopAppBar
import com.sporttest.gymapp.screens.exercise.ExerciseScreen
import com.sporttest.gymapp.screens.history.HistoryScreen
import com.sporttest.gymapp.screens.history.historyNavGraph
import com.sporttest.gymapp.screens.home.HomeScreen
import com.sporttest.gymapp.screens.home.homeNavGraph
import com.sporttest.gymapp.screens.nutrition.NutritionScreen
import com.sporttest.gymapp.screens.profile.ProfileScreen
import com.sporttest.gymapp.viewmodel.HomeViewModel

@Composable
fun MainNavigationGraph(
    rootNavController: NavHostController,
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    androidx.compose.material.Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                //TODO Move chose title to utils file
                title = when (val currentRoute = navBackStackEntry?.destination?.route) {
                    BottomBarDestinations.Home.route -> "Home"
                    BottomBarDestinations.History.route -> "Activity"
                    BottomBarDestinations.Exercise.route -> "Exercise"
                    BottomBarDestinations.Nutrition.route -> "Nutrition"
                    BottomBarDestinations.Profile.route -> "Profile"
                    HistoryDestinations.EditActivity.route -> "Edit Activity"
                    else -> ""
                },
                showAccountButton = navBackStackEntry?.destination?.route != BottomBarDestinations.Profile.route,
                onAccountButtonClick = {
                    //TODO add validation
                    navController.navigate(BottomBarDestinations.Profile.route)
                },
            )
        },
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
                HomeScreen(
                    navController = navController,
                    homeViewModel = homeViewModel
                )
            }

            composable(route = BottomBarDestinations.History.route) {
                HistoryScreen(navController = navController)
            }

            composable(route = BottomBarDestinations.Exercise.route) {
                ExerciseScreen(navController = navController)
            }

            composable(route = BottomBarDestinations.Nutrition.route) {
                NutritionScreen(
                    rootNavController = rootNavController,
                    navController = navController,
                    homeViewModel = homeViewModel
                )
            }

            composable(route = BottomBarDestinations.Profile.route) {
                ProfileScreen(navController = navController)
            }

            historyNavGraph(
                navController = navController,
                homeViewModel = homeViewModel
            )

            homeNavGraph(navController = navController)
        }
    }
}