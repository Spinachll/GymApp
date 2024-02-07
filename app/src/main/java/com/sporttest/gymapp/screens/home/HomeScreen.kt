package com.sporttest.gymapp.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.HomeNavigationGraph

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()
) {
    HomeNavigationGraph(navController = navController)
}