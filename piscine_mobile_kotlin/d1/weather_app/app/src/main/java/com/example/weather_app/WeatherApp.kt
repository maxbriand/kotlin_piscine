package com.example.weather_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.example.weather_app.pages.TodayPage

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            var currentPage : String by remember {mutableStateOf()}

            Weather_appTheme {
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
                    bottomBar = {
                        NavigationBar(
                            content = {},
                            contentColor = Color(0xFFFFFFFF),
                            containerColor = Color(0xFF5B5E72),
                            windowInsets = NavigationBarDefaults.windowInsets
                        )
                    }
                ) { innerPadding ->
                    Content(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Content(name: String, modifier: Modifier = Modifier) {
      

        TodayPage(Modifier)
//    }// 0xFFFEFBFF


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Weather_appTheme {
        Content("Android")
    }
}