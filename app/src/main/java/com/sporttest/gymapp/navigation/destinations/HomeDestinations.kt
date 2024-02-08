package com.sporttest.gymapp.navigation.destinations

sealed class HomeDestinations(val route: String) {
    object HomeRoot : HomeDestinations(route = "HOME_ROOT")
    object AddWidget : HomeDestinations(route = "ADD_WIDGET")
}