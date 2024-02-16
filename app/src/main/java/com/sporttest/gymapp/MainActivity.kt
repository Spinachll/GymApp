package com.sporttest.gymapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.RootNavigationGraph
import com.sporttest.gymapp.ui.theme.GymAppTheme
import com.sporttest.gymapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymAppTheme {
                RootNavigationGraph(
                    navController = rememberNavController(),
                    homeViewModel = homeViewModel
                )
            }
        }
    }
}