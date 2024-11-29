package com.vijaykuppli.android.screen.stateflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import kotlin.random.Random

class StateFlowExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colorState = remember { mutableStateOf(Color.Yellow) }
            Column(modifier = Modifier.fillMaxSize()) {
                StateFlowExample(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    updateColor = {
                        colorState.value = it
                    }
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .background(colorState.value)
                )
            }
        }
    }
}

@Composable
fun StateFlowExample(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Button(onClick = {
            updateColor(
                Color(Random.nextInt())
            )
        }) {
            Text(
                text = "Click To Change BG",
                textAlign = TextAlign.Center
            )
        }
    }
}
