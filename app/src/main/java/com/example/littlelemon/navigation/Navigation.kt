package com.example.littlelemon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.components.Home
import com.example.littlelemon.components.Onboarding
import com.example.littlelemon.components.Profile

@Composable
fun AppNavigation(navController: NavHostController) {
    val isLoggedIn = false
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
            Onboarding()
        }

    }

}