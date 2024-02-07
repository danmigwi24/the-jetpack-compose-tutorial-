package com.dk.learningjetpackcompse.ui.modules

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dk.learningjetpackcompse.auth.navigations.authNavigation
import com.dk.learningjetpackcompse.auth.navigations.authRoute

@Composable
fun ModulesNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController, startDestination = authRoute
    ) {
        authNavigation(navController = navHostController) {
        }
    }
}