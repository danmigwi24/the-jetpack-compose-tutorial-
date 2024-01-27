package com.dk.learningjetpackcompse.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {


            Text(
                text = "Details",
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.Green,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Button(
                onClick = {
                    //WHEN YOU WANT TO POPBACK
                    //navController.popBackStack()
                    //WHEN YOU WANT TO MOVE BACK BUT WITH AN ARGUMENT
                    navController.navigate(route = Screen.Home.route){
                        popUpTo(route = Screen.Home.route){
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(66.dp)
                    .padding(
                        start = 64.dp,
                        end = 64.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ),
            ) {
                Text(
                    text = "Back",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


