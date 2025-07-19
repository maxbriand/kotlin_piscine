package com.example.ex01

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DisplayTextAndButton(
                        name = "Android",
                        modifier = Modifier.padding(16.dp),
                        from = "Barnabe",
                    )
            }
        }
    }
}

@Composable
fun DisplayTextAndButton(name: String, modifier: Modifier = Modifier, from: String) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Meraba Ed!",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.size(10.dp))
        Button(
            onClick = { Log.d("App", "Button pressed") },
            modifier = Modifier.size(width = 120.dp, height = 40.dp)
        ) { Text("Click me", style = MaterialTheme.typography.bodySmall) }
    }

}

@Preview(showBackground = true)
@Composable
fun DisplayTextAndButtonPreview() {

        DisplayTextAndButton("Android", from = "jdjd")
}
