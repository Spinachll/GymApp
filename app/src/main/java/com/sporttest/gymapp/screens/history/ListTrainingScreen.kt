package com.sporttest.gymapp.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.sporttest.gymapp.navigation.destinations.HistoryDestinations
import com.sporttest.gymapp.ui.theme.BlueHorizontalGradient
import com.sporttest.gymapp.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListTrainingScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    val localContext = LocalContext.current

    val pullRefreshState = rememberPullRefreshState(homeViewModel.isRefreshing.value,
        {
            homeViewModel.getTrainingList(localContext)
        }
    )

    LaunchedEffect(key1 = 1, block = {
        if (!homeViewModel.trainingListLoaded) {
            homeViewModel.getTrainingList(localContext)
            homeViewModel.trainingListLoaded = true
        }
    })

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        HistoryDestinations.trainingEditNavigation()
                    )
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add training")
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .pullRefresh(pullRefreshState)
        )
        {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(homeViewModel.trainingList) { training ->
                    Text(
                        text = training.name ?: "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(brush = BlueHorizontalGradient)
                            .clickable {
                                navController.navigate(
                                    HistoryDestinations.trainingEditNavigation(training.id ?: -1)
                                )
                            }
                            .padding(all = 16.dp),
                        color = Color.White
                    )
                }
            }

            PullRefreshIndicator(
                homeViewModel.isRefreshing.value,
                pullRefreshState,
                Modifier.align(Alignment.TopCenter)
            )

        }
    }
}