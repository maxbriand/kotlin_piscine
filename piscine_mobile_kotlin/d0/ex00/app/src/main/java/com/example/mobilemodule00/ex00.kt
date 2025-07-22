package com.example.mobilemodule00

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
import com.example.mobilemodule00.ui.theme.MobileModule00Theme
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
            MobileModule00Theme {
                DisplayTextAndButton(
                    name = "A simple text",
                    modifier = Modifier.padding(16.dp),
                    buttonName = "Click me",
                )
            }
        }
    }
}

@Composable
fun DisplayTextAndButton(name: String, modifier: Modifier = Modifier, buttonName: String) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.size(10.dp))
        Button(
            onClick = { Log.d("App", "Button pressed") },
            modifier = Modifier.size(width = 120.dp, height = 40.dp)
        ) { Text(buttonName, style = MaterialTheme.typography.bodySmall) }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayTextAndButtonPreview() {
    MobileModule00Theme {
        DisplayTextAndButton("Android", buttonName = "jdjd")
    }
}
