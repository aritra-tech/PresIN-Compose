package com.twomusketeers.presin_compose.navigation

import com.twomusketeers.presin_compose.utils.Constants

sealed class Screens(val name: String) {

    object LogIn : Screens(Constants.LOGIN)
    object Register : Screens(Constants.REGISTER)
    object ForgotPassword : Screens(Constants.FORGOT_PASSWORD)
    object ResetPassword : Screens(Constants.RESET_PASSWORD)
    object VerifyOTP : Screens(Constants.VERIFY_OTP)
    object Home : Screens(Constants.HOME)
    object AttendeesList : Screens(Constants.ATTENDEES_LIST)
}