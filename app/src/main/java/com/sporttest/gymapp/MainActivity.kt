package com.sporttest.gymapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.RootNavigationGraph
import com.sporttest.gymapp.ui.theme.GymAppTheme
import com.sporttest.gymapp.ui.theme.White
import com.sporttest.gymapp.viewmodel.HomeViewModel
import com.sporttest.gymapp.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val homeViewModel by viewModels<HomeViewModel>()
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymAppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    RootNavigationGraph(
                        navController = rememberNavController(),
                        homeViewModel = homeViewModel,
                        loginViewModel = loginViewModel
                    )
                }
            }
        }
    }
}