package com.sporttest.gymapp.navigation.destinations

sealed class AuthDestinations(val route: String) {
    object AuthRoot : HomeDestinations(route = "AUTH_ROOT")
    object RestorePassword : HomeDestinations(route = "RESTORE_PASSWORD")
}