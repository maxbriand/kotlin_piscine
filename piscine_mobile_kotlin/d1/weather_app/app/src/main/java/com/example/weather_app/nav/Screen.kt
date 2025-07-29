package com.example.weather_app.nav

sealed class Screen (val route: String) {
    object Currently : Screen("Currently")
    object Today : Screen("Today")
    object Weekly : Screen("Weekly")
}