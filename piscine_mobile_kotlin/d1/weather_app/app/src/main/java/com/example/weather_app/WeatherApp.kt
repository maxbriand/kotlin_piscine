package com.example.weather_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.weather_app.ui.theme.Weather_appTheme
import com.example.weather_app.screen.TodayScreen
import com.example.weather_app.nav.Screen
import kotlinx.serialization.Serializable


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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
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
        },
        //bottomBar = //BottomBar {  },
    ) { innerPadding ->
        NavSystem()


    }
}

@Serializable
object Profile

@Serializable
object FriendsList

@Composable
fun NavSystem() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Profile) {
        composable
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Weather_appTheme {
        Content("Android")
    }
}