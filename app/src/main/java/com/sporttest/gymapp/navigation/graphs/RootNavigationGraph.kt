package com.sporttest.gymapp.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sporttest.gymapp.data.datastore.AppValuesStore
import com.sporttest.gymapp.screens.MainScreen
import com.sporttest.gymapp.screens.auth.AuthMainScreen
import com.sporttest.gymapp.viewmodel.HomeViewModel
import com.sporttest.gymapp.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    loginViewModel: LoginViewModel
) {
    NavHost(
        navController = navController, route = Graph.ROOT, startDestination = Graph.AUTH
    ) {
        composable(route = Graph.MAIN) {
            MainScreen(
                rootNavController = navController, homeViewModel = homeViewModel
            )
        }

        composable(route = Graph.AUTH) {
            val context = LocalContext.current
            val dataStore = AppValuesStore(context)
            val scope = rememberCoroutineScope()
            LaunchedEffect(true) {
                scope.launch {
                    loginViewModel.userToken.value = dataStore.getUserToken.first() ?: ""
                }
            }
            if (
                (loginViewModel.isSuccessLoading.value || loginViewModel.userToken.value.isNotEmpty()) &&
                !homeViewModel.logoutProcess
            ) {
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
                AuthMainScreen(
                    rootNavController = navController, loginViewModel = loginViewModel
                )
            }
        }
    }
}