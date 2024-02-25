package com.example.littlelemon.navigation

interface Destinations {
    val route: String
}

object Home: Destinations {
    override val route: String = "home"
}

object Onboarding: Destinations {
    override val route: String = "onboarding"
}

object Profile: Destinations {
    override val route: String = "profile"
}