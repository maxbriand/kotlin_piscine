package com.example.ex02

import android.R
import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ex02.ui.theme.Ex02Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.material3.LocalTextStyle
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ex02Theme {
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
    var calculInput by remember { mutableStateOf("0") }
    var result by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CenterAlignedTopAppBar(
            title = { Text("Calculator", color = Color.White) },
            colors = TopAppBarDefaults.topAppBarColors(Color(0xFF3F51B5)), //#3F51B5
        )
        TextField(
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
            value = calculInput, onValueChange = { calculInput = it },
            modifier = Modifier
                .fillMaxWidth()
        )
        TextField(
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
            value = result, onValueChange = { calculInput = it }, modifier = Modifier
                .fillMaxWidth()
        )
        keyboard()
    }
}

@Composable
fun keyboard() {
    val keyboards: Map<String, () -> Unit> = mapOf(
        "7" to {},
        "8" to {},
        "9" to {},
        "C" to {},
        "AC" to {},
        "4" to {},
        "5" to {},
        "6" to {},
        "+" to {},
        "-" to {},
        "1" to {},
        "2" to {},
        "3" to {},
        "x" to {},
        "/" to {},
        "0" to {},
        "." to {},
        "00" to {},
        "=" to {},
    )
    var i = 0;

    while (true) {
        if (i >= 18) break;
        Row(
            modifier = Modifier
                .fillMaxWidth(),

            ) {
            for ((key, function) in keyboards.entries.drop(i).take(5)) {
                Button(
                    modifier = Modifier
                        .weight(1f),
                    onClick = function,
                    content = { Text(key) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF607D8B),
                        contentColor = Color.White
                    ),
                    shape = RectangleShape,
                )
                i++;
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ex02Theme {
        Greeting("Android")
    }
}