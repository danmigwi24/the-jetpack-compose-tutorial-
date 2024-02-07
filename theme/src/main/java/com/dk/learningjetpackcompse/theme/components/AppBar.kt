package com.dk.learningjetpackcompse.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.dk.learningjetpackcompse.theme.LearningJetpackCompseTheme
import dev.belalkhan.minitales.theme.components.MiniTalesPreview

@Composable
fun Appbar(
    title: String,
    navIcon: ImageVector? = null,
    onNav: () -> Unit = {},
) {

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(text = title)
        },
        navigationIcon = {
            navIcon?.let {
                IconButton(onClick = { onNav() }) {
                    Icon(navIcon, contentDescription = "Nav Icon")
                }
            }
        },
    )
}

@Composable
@MiniTalesPreview
private fun AppBarPreview() {
    LearningJetpackCompseTheme {
        Surface {
            Appbar(
                title = "Mini Tales",
                navIcon = Icons.Filled.ArrowBack,
            )
        }
    }
}
