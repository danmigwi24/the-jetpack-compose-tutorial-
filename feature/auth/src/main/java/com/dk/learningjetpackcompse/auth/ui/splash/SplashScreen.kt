package com.dk.learningjetpackcompse.auth.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dk.learningjetpackcompse.auth.R
import com.dk.learningjetpackcompse.theme.LearningJetpackCompseTheme
import dev.belalkhan.minitales.theme.components.MiniTalesPreview

@Composable
fun SplashScreen() {
    Splash()
}


@Composable
private fun Splash() {
Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
    Icon(
        painter = painterResource(id = R.drawable.daniel_bg),
        contentDescription = "",
        modifier = Modifier.clip(RoundedCornerShape(size = 20.dp))
    )
}
}


@MiniTalesPreview
@Composable
private fun SplashPreview() {
LearningJetpackCompseTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
        Splash()
    }
}
}