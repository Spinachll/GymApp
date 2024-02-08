package com.sporttest.gymapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.sporttest.gymapp.navigation.graphs.RootNavigationGraph
import com.sporttest.gymapp.ui.theme.GymAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymAppTheme {
                    RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}