package com.example.weather_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather_app.ui.theme.Weather_appTheme
import java.nio.file.WatchEvent
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import android.graphics.pdf.content.PdfPageGotoLinkContent.Destination
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Weather_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    val navController = rememberNavController()
//    val startDestination = Destination.SONGS
//    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Column(
        modifier = Modifier
            .background(color = Color(0xFFFFFFFF))
            .fillMaxSize()
    ) {
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
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
//            BottomAppBar(
//                containerColor = , content = { Text("hdhdh") })
            NavigationBar(
                content = {},
                contentColor = Color(0xFFFFFFFF),
                containerColor = Color(0xFF5B5E72),
                windowInsets = NavigationBarDefaults.windowInsets
            ){
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = destination.route)
                            selectedDestination = index
                        },
                        icon = {
                            Icon(
                                destination.icon,
                                contentDescription = destination.contentDescription
                            )
                        },
                        label = { Text(destination.label) }
                    )
                }
            }

        }
    }// 0xFFFEFBFF


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Weather_appTheme {
        Greeting("Android")
    }
}