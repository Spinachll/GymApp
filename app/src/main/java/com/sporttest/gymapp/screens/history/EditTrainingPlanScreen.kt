package com.sporttest.gymapp.screens.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sporttest.gymapp.network.activity.ActivityDto
import com.sporttest.gymapp.network.training.TrainingDto
import com.sporttest.gymapp.network.training.TrainingDtoMutable
import com.sporttest.gymapp.screens.components.MainButton
import com.sporttest.gymapp.screens.components.NumberInput
import com.sporttest.gymapp.screens.components.TextInput
import com.sporttest.gymapp.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun EditTrainingPlanScreen(
    trainingId: Int = -1,
    navController: NavHostController,
    homeViewModel: HomeViewModel,
) {
    val scope = rememberCoroutineScope()
    val localContext = LocalContext.current

    val editTraining = remember {
        mutableStateOf(value = TrainingDtoMutable())
    }

    LaunchedEffect(Unit, block = {
        println(trainingId)
        scope.launch(Dispatchers.IO) {
            if (trainingId > 0) {
                val trainingDto: TrainingDto =
                    homeViewModel.getTrainingDetails(trainingId, localContext) ?: TrainingDto()
                editTraining.value = TrainingDtoMutable(trainingDto)
            }
        }
    })

    Column(
        modifier = Modifier.padding(all = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TextInput(
            textState = editTraining.value.name,
            leadingIcon = Icons.Default.TextFields,
            placeholderText = "Название"
        )

        TextInput(
            textState = editTraining.value.comment,
            leadingIcon = Icons.Default.TextFields,
            placeholderText = "Комментарий"
        )

        NumberInput(
            textState = editTraining.value.exercisesCount,
            leadingIcon = Icons.Default.Numbers,
            placeholderText = "Количество упражнений"
        )

        NumberInput(
            textState = editTraining.value.plannedDuration,
            leadingIcon = Icons.Default.Numbers,
            placeholderText = "Планируемая длительность"
        )

        MainButton(
            text = "Сохранить"
        ) {
            homeViewModel.updateTraining(
                TrainingDto(
                    id = editTraining.value.id.value,
                    plannedDuration = editTraining.value.plannedDuration.value,
                    exercisesCount = editTraining.value.exercisesCount.value,
                    name = editTraining.value.name.value,
                    comment = editTraining.value.comment.value
                ),
                localContext
            )
        }
    }
}