package com.dk.learningjetpackcompse.ui.navigation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dk.learningjetpackcompse.theme.LearningJetpackCompseTheme

class LearnNavigationMainActivity : ComponentActivity() {
lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackCompseTheme {
                navController = rememberNavController()
                SetUpNavGraph(navHostController = navController)
            }
        }
    }
}
