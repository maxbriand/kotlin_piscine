package com.example.weather_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather_app.ui.theme.Weather_appTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavGraphNavigator
import androidx.navigation.compose.rememberNavController
import com.example.weather_app.screen.TodayScreen
import com.example.weather_app.screen.WeeklyScreen
import com.example.weather_app.screen.CurrentlyScreen
import com.example.weather_app.nav.Screen
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.NavigationBarItem
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.weather_app.nav.appNavGraph
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.NavHost

// your own nav‐graph and routes
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Weather_appTheme {
            Content("jdjd")
//            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(name: String, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val items: List<Pair<Screen, ImageVector>> = listOf(
        Screen.Currently to Icons.Default.Home,
        Screen.Today     to Icons.Default.Today,
        Screen.Weekly    to Icons.Default.DateRange
    )

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CenterAlignedTopAppBar(
            colors = TopAppBarColors(
                Color(0xFF5B5E72),
                scrolledContainerColor = Color(0xFF5B5E72),
                titleContentColor = Color(0xFFFFFFFF),
                navigationIconContentColor = Color(0xFF5B5E72),
                actionIconContentColor = Color(0xFF5B5E72)
            ),
            title = { Text("Weather") },
        )
    }, bottomBar = {
        NavigationBar(
            contentColor = Color(0xFFFFFFFF),
            containerColor = Color(0xFF5B5E72),
            windowInsets = NavigationBarDefaults.windowInsets
        ) {
            listOf(
                Screen.Currently to Icons.Default.Home,
                Screen.Today to Icons.Default.Today,
                Screen.Weekly to Icons.Default.DateRange
            ).forEach { (screen, icon) ->
                NavigationBarItem(
                    icon = { Icon(icon, contentDescription = screen.route) },
                    label = { Text(screen.route.capitalize()) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        if (currentRoute != screen.route) {
                            navController.navigate(screen.route) {
                                // optional: popUpTo start to avoid building a huge back‐stack
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                // avoid multiple copies
                                launchSingleTop = true
                                // restore state when re‑selecting
                                restoreState = true
                            }
                        }
                    })
            }
        }
    }) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Currently.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            appNavGraph(navController)  // now resolves!
        }
        Row(modifier = Modifier.padding(innerPadding)) {
            TodayScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Weather_appTheme {
        Content("Android")
    }
}