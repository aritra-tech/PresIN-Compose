package com.twomusketeers.presin_compose.navigation

import com.twomusketeers.presin_compose.utils.Constants

sealed class Screens(val name: String) {

    object LogIn : Screens(Constants.LOGIN)
    object Register : Screens(Constants.REGISTER)
    object Home : Screens(Constants.HOME)
}