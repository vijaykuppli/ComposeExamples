package com.vijaykuppli.android.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class ColumnExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * This function to make transparent app bar.
         * Enable and run the app to check the output
         */
//        enableEdgeToEdge()

        setContent {
            ColumnExampleWithAlignment()
        }
    }
}

/**
 * This is the example to set all textviews in Vertical manner
 */

@Composable
fun ColumnExample() {
    Column {
        Text(text = "Vijay Santosh")
        Text(text = "Pavani")
        Text(text = "Jayansh Krishna")
    }
}

/**
 * This is the example to set the textviews center with same space
 * 1. If you use column use horizontalAlignment and verticalArrangement both otherwise it
 * won't give any impact on the UI.
 * 2. Modifier is the betteer attribute to set column width and height. Instead of fillMaxSize
 * we can specify width and height manually like width(20.dp), height(30.dp)
 */

@Composable
fun ColumnExampleWithAlignment() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Vijay Santosh")
        Text(text = "Pavani")
        Text(text = "Jayansh Krishna")
    }
}