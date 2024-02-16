package com.sporttest.gymapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.MainNavigationGraph
import com.sporttest.gymapp.viewmodel.HomeViewModel

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    homeViewModel: HomeViewModel
) {
    MainNavigationGraph(
        navController = navController,
        homeViewModel = homeViewModel
    )
}