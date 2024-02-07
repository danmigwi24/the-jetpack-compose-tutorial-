package com.dk.learningjetpackcompse.auth.ui.login

sealed class  LoginUiEvents {

    data class  EmailChanged(var email:String):LoginUiEvents()
    data class  PasswordChanged(var password:String):LoginUiEvents()
    //
    data object  Login:LoginUiEvents()
    data object  ForgotPassword:LoginUiEvents()
    data object  SingUp:LoginUiEvents()
}