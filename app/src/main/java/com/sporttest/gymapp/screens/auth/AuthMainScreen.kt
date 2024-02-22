package com.sporttest.gymapp.screens.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.AuthNavigationGraph
import com.sporttest.gymapp.viewmodel.LoginViewModel

@Composable
fun AuthMainScreen(
    rootNavController: NavHostController,
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel
) {
    AuthNavigationGraph(
        rootNavController = rootNavController,
        navController = navController,
        loginViewModel = loginViewModel
    )
}