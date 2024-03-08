package com.sporttest.gymapp.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.sporttest.gymapp.data.datastore.AppValuesStore
import com.sporttest.gymapp.network.workout.WorkoutDto
import com.sporttest.gymapp.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "HomeScreen")
            
        UserList(viewModel = homeViewModel)
    }
}

@Composable
fun UserList(viewModel: HomeViewModel) {

    val activityList = viewModel.activityPager.collectAsLazyPagingItems()
    val scope = rememberCoroutineScope()
    val dataStore = AppValuesStore(LocalContext.current)
    LaunchedEffect(true) {
        scope.launch {
            println("USER TOKEN" + dataStore.getUserToken.first())
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(activityList) { item ->
            item?.let {
                UserCard(workoutDto = it)
            }
        }
    }
}

@Composable
fun UserCard(workoutDto: WorkoutDto) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(workoutItem.picture)
//                    .crossfade(true)
//                    .build(),
//                contentDescription = "Placeholder",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .width(42.dp)
//                    .height(42.dp)
//            )
            Text(
                text = workoutDto.name,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}
