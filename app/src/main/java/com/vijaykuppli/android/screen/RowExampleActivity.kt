package com.vijaykuppli.android.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class RowExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RowWithWidthExample()
        }
    }
}

@Composable
fun RowExample() {
    Row {
        Text(text = "Vijay Santosh")
        Text(text = "Pavani")
        Text(text = "Jayansh Krishna")
    }
}

/**
 * This is the example to set the textviews center with same space
 * 1. If you use row use horizontalArrangement and verticalAlignment both otherwise it
 * won't give any impact on the UI.
 * 2. Modifier is the betteer attribute to set row width and height. Instead of fillMaxSize
 * we can specify width and height manually like width(20.dp), height(30.dp)
 */
@Composable
fun RowWithArrangementExample() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Vijay Santosh")
        Text(text = "Pavani")
        Text(text = "Jayansh Krishna")
    }
}

@Composable
fun RowWithWidthExample() {
    Row(
        modifier = Modifier
            .background(Color.Red)
//            .fillMaxWidth(0.5f)
//            .width(600.dp) // this takes 600 dp of width even though screen width exceeds.
//            .requiredWidth(600.dp) // this takes 600 dp as required to set the width.
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        Text(
            text = "Vijay Santosh",
            color = Color.Yellow,
            modifier = Modifier
                .background(Color.Blue)
        )
        Text(text = "Pavani")
        Text(text = "Jayansh Krishna")
    }
}