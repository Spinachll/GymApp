package com.sporttest.gymapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.MainNavigationGraph

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    MainNavigationGraph(navController = navController)
}