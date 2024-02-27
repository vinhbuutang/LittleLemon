package com.example.littlelemon.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.ui.components.home.HomeScreen
import com.example.littlelemon.ui.components.onboard.OnboardingScreen
import com.example.littlelemon.ui.components.profile.ProfileScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    val context = LocalContext.current

    val sharedPreferences = context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("firstName", "")
    val lastName = sharedPreferences.getString("lastName", "")
    val email = sharedPreferences.getString("email", "")

    val isLoggedIn = firstName!!.isNotBlank() && lastName!!.isNotBlank() && email!!.isNotBlank()

    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) Home.route else Onboarding.route
    ) {
        composable(Home.route) {
            HomeScreen(onNavigateToProfile = { navController.navigate(Profile.route) })
        }
        composable(Profile.route) {
            ProfileScreen(onNavigateToOnboarding = { navController.navigate(Onboarding.route) })
        }
        composable(Onboarding.route) {
            OnboardingScreen(onNavigateToHome = { navController.navigate(Home.route) })
        }
    }

}