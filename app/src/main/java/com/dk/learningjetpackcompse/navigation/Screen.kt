package com.dk.learningjetpackcompse.navigation

sealed class Screen(val route:String) {
    object Home:Screen(route = "home_screen")
    object Detail:Screen(route = "details_screen")
}