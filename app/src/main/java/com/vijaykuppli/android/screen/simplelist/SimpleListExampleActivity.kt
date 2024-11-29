package com.vijaykuppli.android.screen.simplelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SimpleListExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleListExample()
        }
    }
}

@Composable
fun SimpleListExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        for (i in 1..10) {
            val colorCode = if (i % 2 == 0) {
                Color.Green
            } else {
                Color.Black
            }
            Text(
                text = "Loading $i",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                color = colorCode
            )
            Spacer(
                modifier = Modifier
                    .height(30.dp)
            )
        }
    }
}