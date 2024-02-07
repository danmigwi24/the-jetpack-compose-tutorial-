package com.dk.learningjetpackcompse.auth.ui.login

import androidx.compose.runtime.Composable


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dk.learningjetpackcompse.auth.R
import com.dk.learningjetpackcompse.theme.LearningJetpackCompseTheme
import com.dk.learningjetpackcompse.theme.components.AppTextField
import dev.belalkhan.minitales.theme.components.MiniTalesPreview


@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val uiStates = viewModel.uiState.collectAsStateWithLifecycle()
    Login(
        uiStates = uiStates.value,
        onEvents = {
            viewModel.onEvents(it)
        })
}

@Composable
fun Login(
    uiStates: LoginUIStates,
onEvents:( LoginUiEvents) ->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Icon(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 42.dp, bottom = 32.dp),
            //
            painter = painterResource(id = R.drawable.daniel_logo),
            contentDescription = "mini tales"
        )

        AppTextField(
            value = uiStates.email,
            label = R.string.email,
            hint = "yourname@domain.com",
            leadingIcon = Icons.Filled.Email,
            imeAction = ImeAction.Next,
            onValueChanged = {
                onEvents(LoginUiEvents.EmailChanged(it))
            }
        )

        AppTextField(
            value = uiStates.password,
            label = R.string.password,
            hint = "password",
            leadingIcon = Icons.Filled.Lock,
            imeAction = ImeAction.Done,
            isPasswordField = true,
            onValueChanged = {
                onEvents(LoginUiEvents.PasswordChanged(it))
            }
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
            ) {
                Text(
                    text = stringResource(R.string.forgot_password),
                    style = MaterialTheme.typography.bodyLarge,
                )

                Text(
                    text = stringResource(R.string.click_here_to_reset),
                    style = MaterialTheme.typography.bodySmall,
                )
            }


            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = "login",
                )
            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp)
                .clickable { },
            text = stringResource(R.string.dont_have_account),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp),
            text = stringResource(R.string.agree_to_terms),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
        )

    }
}

@MiniTalesPreview
@Composable
private fun LoginScreenPreview() {
    LearningJetpackCompseTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Login(
                uiStates = LoginUIStates(),
                onEvents = {}
            )
        }
    }
}