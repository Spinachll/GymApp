package com.sporttest.gymapp.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sporttest.gymapp.screens.MainScreen

@Composable
fun RootNavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.MAIN
    ) {
        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}