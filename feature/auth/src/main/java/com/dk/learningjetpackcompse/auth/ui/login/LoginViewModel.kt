package com.dk.learningjetpackcompse.auth.ui.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {

    private var _uiState: MutableStateFlow<LoginUIStates> = MutableStateFlow(LoginUIStates())
    val uiState: StateFlow<LoginUIStates> = _uiState


    fun onEvents(uiEvents: LoginUiEvents) {
        when (uiEvents) {
            is LoginUiEvents.EmailChanged -> {
                _uiState.value = _uiState.value.copy(email = uiEvents.email)
            }
            is LoginUiEvents.PasswordChanged -> {
                _uiState.value = _uiState.value.copy(password = uiEvents.password)
            }

            else -> {}
        }
    }
}