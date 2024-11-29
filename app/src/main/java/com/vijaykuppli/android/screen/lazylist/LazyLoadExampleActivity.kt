package com.vijaykuppli.android.screen.lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vijaykuppli.android.screen.lazylist.ui.theme.ComposeExamplesTheme

class LazyLoadExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnIndexItemExample()
        }
    }
}

@Composable
fun LazyColumnItemsExample() {
    LazyColumn {
        items(count = 100) {
            val colorCode = if (it % 2 == 0) {
                Color.Green
            } else {
                Color.Black
            }
            Text(
                text = "Loading $it",
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

@Composable
fun LazyColumnIndexItemExample() {
    LazyColumn {
        itemsIndexed(items = listOf("Vijay", "Santosh", "Kumar", "Kuppli")) { index, string ->
            Text(
                text = "Loading $string",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(
                modifier = Modifier
                    .height(30.dp)
            )
        }
    }
}