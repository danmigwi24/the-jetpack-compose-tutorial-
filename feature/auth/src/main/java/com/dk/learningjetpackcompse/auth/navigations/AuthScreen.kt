package com.dk.learningjetpackcompse.auth.navigations

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dk.learningjetpackcompse.auth.ui.login.LoginScreen
import com.dk.learningjetpackcompse.auth.ui.splash.SplashScreen


const val authRoute = "auth"

sealed class AuthScreen(val route: String) {
    data object Splash : AuthScreen("$authRoute/splash")
    data object Login : AuthScreen("$authRoute/login")
    data object Signup : AuthScreen("$authRoute/signup")
}


fun NavGraphBuilder.authNavigation(
    navController: NavController,
    onAuthSuccess: () -> Unit,
) {
    navigation(startDestination = AuthScreen.Splash.route, route = authRoute) {
        composable(route = AuthScreen.Splash.route) {
            SplashScreen()
            navController.navigate(AuthScreen.Login.route)
        }
        //
        composable(route = AuthScreen.Login.route) {
            LoginScreen(viewModel())
        }
    }
}