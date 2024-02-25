package com.example.littlelemon.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.components.Home
import com.example.littlelemon.components.Onboarding
import com.example.littlelemon.components.Profile

@Composable
fun AppNavigation(navController: NavHostController) {
    val context = LocalContext.current

    val sharedPreferences = context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("firstName", "")
    val lastName = sharedPreferences.getString("lastName", "")
    val email = sharedPreferences.getString("email", "")

    val isLoggedIn = !(firstName!!.isBlank() || lastName!!.isBlank() || email!!.isBlank())

    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) Home.route else Onboarding.route
    ) {
        composable(Home.route) {
            Home()
        }
        composable(Profile.route) {
            Profile()
        }
        composable(Onboarding.route) {
            Onboarding(navController = navController)
        }

    }

}