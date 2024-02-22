package com.sporttest.gymapp.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.Graph
import com.sporttest.gymapp.screens.components.TextInput
import com.sporttest.gymapp.viewmodel.HomeViewModel
import com.sporttest.gymapp.viewmodel.LoginViewModel

@Composable
fun AuthScreen(
    rootNavController: NavHostController,
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel,
    onClickLogin: (email: String, password: String) -> Unit,
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                //TODO move this to util file
                onClickLogin("Test", "Test")

//            rootNavController.popBackStack(Graph.ROOT, true)
//            Graph.MAIN.let {
//                rootNavController.navigate(Graph.MAIN)
//            }
            }
        ) {
            Text(text = "Go to home")
        }

        TextInput()

    }
    /*MainNavigationGraph(
        navController = navController,
        homeViewModel = homeViewModel
    )*/
}