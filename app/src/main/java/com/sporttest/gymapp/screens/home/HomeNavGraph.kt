package com.sporttest.gymapp.screens.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sporttest.gymapp.navigation.destinations.HomeDestinations

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        route = HomeDestinations.HomeRoot.route,
        startDestination = HomeDestinations.AddWidget.route
    ) {
        composable(route = HomeDestinations.AddWidget.route) {
            Text(text = "AddWidget", modifier = Modifier.fillMaxWidth())
        }
    }
}