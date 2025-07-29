package com.example.weather_app.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather_app.nav.Screen
import com.example.weather_app.screen.CurrentlyScreen
import com.example.weather_app.screen.TodayScreen
import com.example.weather_app.screen.WeeklyScreen

fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    composable(Screen.Currently.route) { CurrentlyScreen() }
    composable(Screen.Today.route) { TodayScreen() }
    composable(Screen.Weekly.route) { WeeklyScreen() }
}
