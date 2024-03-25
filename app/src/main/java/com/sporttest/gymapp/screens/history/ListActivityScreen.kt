package com.sporttest.gymapp.screens.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.sporttest.gymapp.viewmodel.HomeViewModel

@Composable
fun ListActivityScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    val localContext = LocalContext.current

    LaunchedEffect(Unit, block = {
        homeViewModel.getActivityList(localContext)
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text("ListActivityScreen")
        LazyColumn() {
            
            items(homeViewModel.activityList) { activity ->
                Text(text = activity.name?:"")
            }
        }
    }
}