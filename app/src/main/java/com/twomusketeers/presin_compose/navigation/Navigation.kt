package com.twomusketeers.presin_compose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.twomusketeers.presin_compose.model.BottomNavItem
import com.twomusketeers.presin_compose.ui.screens.auth_flow.forgot_password.ForgotPassword
import com.twomusketeers.presin_compose.ui.screens.auth_flow.forgot_password.ResetPassword
import com.twomusketeers.presin_compose.ui.screens.auth_flow.forgot_password.VerifyOTP
import com.twomusketeers.presin_compose.ui.screens.auth_flow.login.LoginFlow
import com.twomusketeers.presin_compose.ui.screens.main_flow.AttendeesList
import com.twomusketeers.presin_compose.ui.screens.main_flow.HomeScreen
import com.twomusketeers.presin_compose.utils.Constants.ATTENDEES_LIST
import com.twomusketeers.presin_compose.utils.Constants.AUTH_FLOW
import com.twomusketeers.presin_compose.utils.Constants.FORGOT_PASSWORD
import com.twomusketeers.presin_compose.utils.Constants.HOME
import com.twomusketeers.presin_compose.utils.Constants.LOGIN
import com.twomusketeers.presin_compose.utils.Constants.MAIN_FLOW
import com.twomusketeers.presin_compose.utils.Constants.RESET_FLOW
import com.twomusketeers.presin_compose.utils.Constants.RESET_PASSWORD
import com.twomusketeers.presin_compose.utils.Constants.VERIFY_OTP

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val bottomNavItems = getBottomNavItems()

    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()

    val screensWithoutNavBar = listOf(
        Screens.LogIn.name,
        Screens.ForgotPassword.name,
        Screens.ResetPassword.name,
        Screens.VerifyOTP.name,
    )

    Scaffold(
        bottomBar = {
            ShowBottomNavigationBar(
                backStackEntry,
                bottomNavItems,
                screensWithoutNavBar,
                navController
            )
        }
    ) {

        NavHost(
            navController,
            startDestination = AUTH_FLOW,
            modifier = Modifier
                .padding(it)
        ) {

            /**
             * This Flow is dedicated to Main Screens (Bottom Nav)
             */
            navigation(startDestination = HOME, route = MAIN_FLOW) {

                composable(HOME) {
                    HomeScreen()
                }

                composable(ATTENDEES_LIST) {
                    AttendeesList()
                }
            }


            navigation(startDestination = LOGIN, route = AUTH_FLOW) {

                /**
                 * This Flow is dedicated to Login
                 */
                composable(LOGIN) {
                    LoginFlow(navController)
                }

                /**
                 * This Flow is dedicated to Resetting User's Password
                 */
                navigation(startDestination = FORGOT_PASSWORD, route = RESET_FLOW) {

                    composable(FORGOT_PASSWORD) {
                        ForgotPassword(navController)
                    }

                    composable(RESET_PASSWORD) {
                        ResetPassword(navController)
                    }

                    composable(VERIFY_OTP) {
                        VerifyOTP(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun ShowBottomNavigationBar(
    backStackEntry: State<NavBackStackEntry?>,
    bottomNavItems: List<BottomNavItem>,
    screensWithoutNavBar: List<String>,
    navController: NavHostController
) {
    if (backStackEntry.value?.destination?.route !in screensWithoutNavBar) {
        NavigationBar {
            bottomNavItems.forEach { item ->
                NavigationBarItem(
                    alwaysShowLabel = true,
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name,
                            tint = if (backStackEntry.value?.destination?.route == item.route)
                                MaterialTheme.colorScheme.onSurface
                            else
                                MaterialTheme.colorScheme.secondary
                        )
                    },
                    label = {
                        Text(
                            text = item.name,
                            color = if (backStackEntry.value?.destination?.route == item.route)
                                MaterialTheme.colorScheme.onSurface
                            else
                                MaterialTheme.colorScheme.secondary,
                            fontWeight = if (backStackEntry.value?.destination?.route == item.route)
                                FontWeight.Bold
                            else
                                FontWeight.Normal,
                        )
                    },
                    selected = backStackEntry.value?.destination?.route == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

fun getBottomNavItems(): List<BottomNavItem> {
    return listOf(
        BottomNavItem(
            name = "Home",
            route = Screens.Home.name,
            icon = Icons.Rounded.Home,
        ),
        BottomNavItem(
            name = "Attendees",
            route = Screens.AttendeesList.name,
            icon = Icons.Rounded.Settings,
        ),
    )
}