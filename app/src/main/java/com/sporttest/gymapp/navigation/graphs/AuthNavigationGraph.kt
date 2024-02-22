package com.sporttest.gymapp.navigation.graphs

import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sporttest.gymapp.navigation.destinations.AuthDestinations
import com.sporttest.gymapp.navigation.destinations.BottomBarDestinations
import com.sporttest.gymapp.screens.auth.AuthScreen
import com.sporttest.gymapp.screens.components.BottomBar
import com.sporttest.gymapp.screens.exercise.ExerciseScreen
import com.sporttest.gymapp.screens.history.HistoryScreen
import com.sporttest.gymapp.screens.home.HomeScreen
import com.sporttest.gymapp.screens.home.homeNavGraph
import com.sporttest.gymapp.screens.nutrition.NutritionScreen
import com.sporttest.gymapp.viewmodel.HomeViewModel
import com.sporttest.gymapp.viewmodel.LoginViewModel


@Composable
fun AuthNavigationGraph(
    rootNavController: NavHostController,
    navController: NavHostController,
    loginViewModel: LoginViewModel
) {
    NavHost(
        navController = navController,
        route = Graph.AUTH,
        startDestination = AuthDestinations.AuthRoot.route
    ) {
        composable(route = AuthDestinations.AuthRoot.route) {
            AuthScreen(
                rootNavController = rootNavController,
                navController = navController,
                loginViewModel = loginViewModel,
                onClickLogin = loginViewModel::login
            )
        }

    }
}
