package com.dk.learningjetpackcompse.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dk.learningjetpackcompse.auth.navigations.AuthScreen
import com.dk.learningjetpackcompse.auth.navigations.authRoute
import com.dk.learningjetpackcompse.auth.ui.splash.SplashScreen

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ){
        //
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navHostController)
        }
        //
        composable(
            route = Screen.Detail.route
        ){
            DetailsScreen(navHostController)
        }

    }

}
