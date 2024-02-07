package com.sporttest.gymapp.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun MainScreen(
    navController: NavHostController
) {
    Text(
        text = "Main Screen Text",
        modifier = Modifier.fillMaxSize()
    )
}