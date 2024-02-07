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

    object Profile : BottomBarDestinations(
        route = "PROFILE",
        title = "PROFILE",
        icon = Icons.Default.Person
    )
}