package com.sporttest.gymapp.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sporttest.gymapp.navigation.destinations.HistoryDestinations
import com.sporttest.gymapp.ui.theme.BlueHorizontalGradient
import com.sporttest.gymapp.viewmodel.HomeViewModel

@Composable
fun ListTrainingScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    val localContext = LocalContext.current

    LaunchedEffect(Unit, block = {
        homeViewModel.getTrainingList(localContext)
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(homeViewModel.trainingList) { training ->
                Text(
                    text = training.name?:"",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(brush = BlueHorizontalGradient)
                        .clickable {
                            navController.navigate(
                                HistoryDestinations.trainingEditNavigation(training.id?:-1)
                            )
                        }
                        .padding(all = 16.dp),
                    color = Color.White
                )
            }
        }
    }
}