package com.sporttest.gymapp.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sporttest.gymapp.screens.MainScreen
import com.sporttest.gymapp.viewmodel.HomeViewModel

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.MAIN
    ) {
        composable(route = Graph.MAIN) {
            MainScreen(homeViewModel = homeViewModel)
        }
    }
}