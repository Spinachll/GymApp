package com.sporttest.gymapp.screens.auth

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.Graph
import com.sporttest.gymapp.viewmodel.HomeViewModel

@Composable
fun AuthScreen(
    rootNavController: NavHostController,
    navController: NavHostController = rememberNavController(),
    homeViewModel: HomeViewModel
) {
    Button(
        onClick = {
            //TODO move this to util file
            rootNavController.popBackStack(Graph.ROOT, true)
            Graph.MAIN.let {
                rootNavController.navigate(Graph.MAIN)
            }
        }
    ) {
        Text(text = "Go to home")
    }
    /*MainNavigationGraph(
        navController = navController,
        homeViewModel = homeViewModel
    )*/
}