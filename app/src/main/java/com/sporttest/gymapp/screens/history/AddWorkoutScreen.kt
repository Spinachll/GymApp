package com.sporttest.gymapp.screens.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.sporttest.gymapp.viewmodel.HomeViewModel

@Composable
fun AddWorkoutScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Edit Workout")
    }
}