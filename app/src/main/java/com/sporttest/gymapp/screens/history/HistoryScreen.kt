package com.sporttest.gymapp.screens.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sporttest.gymapp.screens.components.ActivityCard

@Composable
fun HistoryScreen(
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(count = 20) {
            ActivityCard(
                onCardClick = { /*TODO*/ },
                onAdditionalButtonClick = { /*TODO*/ },
                title = "Biceps WorkoutBicepsWorkout BicepsWorkout Biceps Workout Biceps Workout ",
                caption = "11 Exercises | 32 mins",
                additionalText = "Data/Time"
            )
        }
    }
}