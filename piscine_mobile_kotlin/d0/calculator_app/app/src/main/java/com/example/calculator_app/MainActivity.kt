package com.example.calculator_app

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
import com.example.calculator_app.ui.theme.Calculator_appTheme
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
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculator_appTheme {
                @Suppress("UnusedMaterial3ScaffoldPaddingParameter")
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { _ ->
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    var calculatorInput by remember { mutableStateOf("0") }
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
            value = calculatorInput, onValueChange = { calculatorInput = it },
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
            onValueChange = { calculatorInput = it },
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
        Keyboard(calculatorInput, { calculatorInput = it }, { result = it })
    }
}

@Composable
fun Keyboard(
    calculatorInput: String,
    onChangeInput: (String) -> Unit,
    onChangeResult: (String) -> Unit
) {
    val keyboards: List<String> = listOf(
        "7",
        "8",
        "9",
        "C",
        "AC",
        "4",
        "5",
        "6",
        "+",
        "-",
        "1",
        "2",
        "3",
        "x",
        "/",
        "0",
        ".",
        "00",
        "="
    )
    var i = 0
    var d = 0
    var colorButton: Color

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        while (true) {
            if (i >= 18) break
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                for (key in keyboards.drop(i).take(5)) {
                    colorButton = setKeyColor(i, d)
                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(0.13f),
                        onClick = {
                            keyBehavior(
                                key = key,
                                calculatorInput = calculatorInput,
                                onChangeInput,
                                onChangeResult = onChangeResult
                            )
                        },
                        content = { Text(key) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF607D8B),
                            contentColor = colorButton,
                        ),
                        shape = RectangleShape,
                    )
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

private fun keyBehavior(
    key: String,
    calculatorInput: String,
    onChangeCalculatorInput: (String) -> Unit,
    onChangeResult: (String) -> Unit
) {
    Log.d("Action: ", key)
    if (key == "AC") {
        onChangeCalculatorInput("0")
        onChangeResult("0")
    } else if (key == "C") {
        if (calculatorInput.length > 1) (onChangeCalculatorInput(calculatorInput.dropLast(1)))
        else if (calculatorInput != "0") {
            onChangeCalculatorInput("0")
        }
    } else if (key == "=") {
        try {
            val xRemoved = calculatorInput.replace("x", "*")
            val total = evaluate(xRemoved)
            val s1 = total.toString()
            onChangeResult(s1)
        } catch (e: Exception) {
            onChangeResult("Error")
        }
    } else {
        if (calculatorInput == "0") {
            onChangeCalculatorInput("" + key)
        } else {
            onChangeCalculatorInput(calculatorInput + key)
        }
    }
}

private fun evaluate(expr: String): Double = ExpressionBuilder(expr).build().evaluate()

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculator_appTheme {
        Greeting()
    }
}