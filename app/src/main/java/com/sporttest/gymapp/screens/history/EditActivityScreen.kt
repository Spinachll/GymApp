package com.sporttest.gymapp.screens.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sporttest.gymapp.network.activity.ActivityDto
import com.sporttest.gymapp.screens.components.MainButton
import com.sporttest.gymapp.screens.components.NumberInput
import com.sporttest.gymapp.screens.components.TextInput
import com.sporttest.gymapp.viewmodel.HomeViewModel

@Composable
fun EditActivityScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    val localContext = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(all = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TextInput(
                textState = homeViewModel.editActivity.value.name,
                leadingIcon = Icons.Default.TextFields,
                placeholderText = "Название"
            )

            NumberInput(
                textState = homeViewModel.editActivity.value.activityType,
                leadingIcon = Icons.Default.Numbers,
                placeholderText = "Тип активности"
            )

            NumberInput(
                textState = homeViewModel.editActivity.value.repetitionsCountMin,
                leadingIcon = Icons.Default.Numbers,
                placeholderText = "Количество повторений min"
            )

            NumberInput(
                textState = homeViewModel.editActivity.value.repetitionsCountMax,
                leadingIcon = Icons.Default.Numbers,
                placeholderText = "Количество повторений max"
            )

            NumberInput(
                textState = homeViewModel.editActivity.value.plannedDuration,
                leadingIcon = Icons.Default.Numbers,
                placeholderText = "Планируемая длительность"
            )

            MainButton(
                text = "Сохранить"
            ) {
                homeViewModel.editActivity(
                    ActivityDto(
                        name = homeViewModel.editActivity.value.name.value,
                        activityType = homeViewModel.editActivity.value.activityType.value,
                        repetitionsCountMin = homeViewModel.editActivity.value.repetitionsCountMin.value,
                        repetitionsCountMax = homeViewModel.editActivity.value.repetitionsCountMax.value,
                        weight = homeViewModel.editActivity.value.weight.value,
                        plannedDuration = homeViewModel.editActivity.value.plannedDuration.value
                    ),
                    localContext
                )
            }
        }
    }
}