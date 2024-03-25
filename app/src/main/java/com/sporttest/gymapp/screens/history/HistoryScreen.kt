package com.sporttest.gymapp.screens.history

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sporttest.gymapp.navigation.destinations.HistoryDestinations
import com.sporttest.gymapp.screens.components.ActivityCard
import com.sporttest.gymapp.screens.components.CardButton
import com.sporttest.gymapp.ui.theme.poppinsFamily

@Composable
fun HistoryScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp)
    ) {
        // Add activities row
        Row(
            modifier = Modifier
                .padding(top = 12.dp, bottom = 12.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            CardButton(
                text = "Edit Workout"
            ) {
                navController.navigate(HistoryDestinations.EditWorkout.route)
            }

            CardButton(
                text = "Edit Training Plan"
            ) {
                navController.navigate(HistoryDestinations.ListTrainingPlan.route)
            }

            CardButton(
                text = "Edit Exercises"
            ) {
                navController.navigate(HistoryDestinations.EditExercise.route)
            }

            CardButton(
                text = "Edit Activities"
            ) {
                navController.navigate(HistoryDestinations.EditActivity.route)
            }
        }

        Row(
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Your recent activities",
                fontWeight = FontWeight.Medium,
                fontFamily = poppinsFamily
            )
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f, fill = true),
            contentPadding = PaddingValues(top = 6.dp),
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

}