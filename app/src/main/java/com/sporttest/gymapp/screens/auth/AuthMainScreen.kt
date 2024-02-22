package com.sporttest.gymapp.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.AuthNavigationGraph
import com.sporttest.gymapp.navigation.graphs.MainNavigationGraph
import com.sporttest.gymapp.screens.components.TextInput
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