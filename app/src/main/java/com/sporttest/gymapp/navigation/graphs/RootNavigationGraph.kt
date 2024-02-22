package com.sporttest.gymapp.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sporttest.gymapp.screens.MainScreen
import com.sporttest.gymapp.screens.auth.AuthScreen
import com.sporttest.gymapp.viewmodel.HomeViewModel
import com.sporttest.gymapp.viewmodel.LoginViewModel

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    loginViewModel: LoginViewModel
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        composable(route = Graph.MAIN) {
            MainScreen(
                rootNavController = navController,
                homeViewModel = homeViewModel
            )
        }

        composable(route = Graph.AUTH) {
            if (loginViewModel.isSuccessLoading.value && !homeViewModel.logoutProcess) {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(route = Graph.MAIN) {
                        popUpTo(route = Graph.AUTH) {
                            inclusive = true
                        }
                    }
                }
            } else {
                homeViewModel.logoutProcess = false
                loginViewModel.isSuccessLoading.value = false
                AuthScreen(
                    rootNavController = navController,
                    loginViewModel = loginViewModel,
                    onClickLogin = loginViewModel::login,
                )
            }
        }
    }
}