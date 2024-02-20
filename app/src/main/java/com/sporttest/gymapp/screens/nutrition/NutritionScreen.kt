package com.sporttest.gymapp.screens.nutrition

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.sporttest.gymapp.navigation.graphs.Graph

@Composable
fun NutritionScreen(
    navController: NavHostController,
    rootNavController: NavHostController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "NutritionScreen")
        Button(
            onClick = {
                rootNavController.popBackStack(Graph.ROOT, true)
                Graph.AUTH.let {
                    rootNavController.navigate(Graph.AUTH)
                }
            }
        ) {
            Text(text = "Go to auth")
        }
    }
}