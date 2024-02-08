package com.sporttest.gymapp.navigation.destinations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarDestinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarDestinations(
        route = "HOME",
        title = "HOME",
        icon = Icons.Default.Home
    )

    object History : BottomBarDestinations(
        route = "HISTORY",
        title = "History",
        icon = Icons.Default.History
    )

    object Exercise : BottomBarDestinations(
        route = "EXERCISE",
        title = "EXERCISE",
        icon = Icons.Default.SportsGymnastics
    )

    object Nutrition : BottomBarDestinations(
        route = "NUTRITION",
        title = "NUTRITION",
        icon = Icons.Default.SetMeal
    )
    object Profile : BottomBarDestinations(
        route = "PROFILE",
        title = "PROFILE",
        icon = Icons.Default.Person
    )
}