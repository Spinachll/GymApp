package com.sporttest.gymapp.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sporttest.gymapp.navigation.destinations.AuthDestinations
import com.sporttest.gymapp.screens.auth.AuthScreen
import com.sporttest.gymapp.screens.auth.RegisterScreen
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

        composable(route = AuthDestinations.RegisterUser.route) {
            RegisterScreen(
                rootNavController = rootNavController,
                navController = navController,
                loginViewModel = loginViewModel
            )
        }

    }
}
