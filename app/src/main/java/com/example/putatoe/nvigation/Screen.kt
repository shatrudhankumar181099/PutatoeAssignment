package com.example.putatoe.nvigation

const val SignUpScreenPath= "SignUpScreen"
const val LoginScreenPath= "LoginScreen"

sealed class Screen (val route:String){
    object SignUpScreen :Screen(SignUpScreenPath)
    object LoginScreen :Screen(LoginScreenPath)

}