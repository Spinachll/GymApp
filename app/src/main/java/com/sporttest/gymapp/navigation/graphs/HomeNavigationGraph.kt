package com.sporttest.gymapp.navigation.graphs

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sporttest.gymapp.navigation.destinations.BottomBarDestinations
import com.sporttest.gymapp.screens.home.MainScreen

@Composable
fun HomeNavigationGraph(
    navController: NavHostController
) {
    Scaffold(

    ) {
        NavHost(
            navController = navController,
            route = Graph.HOME,
            startDestination = BottomBarDestinations.Home.route
        ) {
            composable(route = BottomBarDestinations.Home.route) {
                MainScreen(navController)
            }
        }
    }
}