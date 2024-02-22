package com.sporttest.gymapp.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.sporttest.gymapp.network.workout.WorkoutDto
import com.sporttest.gymapp.viewmodel.HomeViewModel

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

    val usersList = viewModel.usersPager.collectAsLazyPagingItems()

    LazyColumn {
        items(usersList) { item ->
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
