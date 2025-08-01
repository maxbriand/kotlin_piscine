package com.example.weather_app.nav

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector



sealed class Screen (val route: String, val icon: ImageVector) {
    object Currently : Screen("Currently", Icons.Filled.Star)
    object Today : Screen("Today", Icons.Filled.Add)
    object Weekly : Screen("Weekly", Icons.Filled.DateRange)
}