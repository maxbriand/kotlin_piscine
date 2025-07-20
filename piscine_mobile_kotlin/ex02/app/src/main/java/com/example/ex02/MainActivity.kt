package com.example.ex02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.style.TextAlign
import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight


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
            .background(color = Color(0xFF37474F))
    ) {
        CenterAlignedTopAppBar(
            title = { Text("Calculator", color = Color.White) },
            colors = TopAppBarDefaults.topAppBarColors(Color(0xFF607D8B)),
        )
        TextField(
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
            value = calculInput, onValueChange = { calculInput = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF37474F),
                unfocusedContainerColor = Color(0xFF37474F),
                disabledContainerColor = Color(0xFF37474F),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedTextColor = Color(0xFF607D8B),
                unfocusedTextColor = Color(0xFF607D8B),
                disabledTextColor = Color(0xFF607D8B),
            ),
        )
        TextField(
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
            value = result,
            onValueChange = { calculInput = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF37474F),
                unfocusedContainerColor = Color(0xFF37474F),
                disabledContainerColor = Color(0xFF37474F),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedTextColor = Color(0xFF607D8B),
                unfocusedTextColor = Color(0xFF607D8B),
                disabledTextColor = Color(0xFF607D8B),
            )
        )
        Keyboard()
    }
}

@Composable
fun Keyboard() {
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
    var i = 0
    var d = 0
    var colorButton : Color

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,

        ) {
        while (true) {
            if (i >= 18) break
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                for ((key, function) in keyboards.entries.drop(i).take(5)) {
                    colorButton = setKeyColor(i, d)
                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(0.13f),
                        onClick = { behavior(key = key) },
                        content = { Text(key )},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF607D8B),
                            contentColor = colorButton,
                        ),
                        shape = RectangleShape,
                    )
                    Log.d("d", "n = $d")
                    i++
                    d++
                }
                d = 0
            }
        }
    }

}

private fun setKeyColor(i: Int, d: Int): Color = when {
    d < 3 -> Color(0xFF37474F)
    d >= 3 && i < 5 -> Color(0xFF934247)
    else -> Color.White
}

private fun behavior(key: String) {
    Log.d("Action: ", key)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ex02Theme {
        Greeting("Android")
    }
}