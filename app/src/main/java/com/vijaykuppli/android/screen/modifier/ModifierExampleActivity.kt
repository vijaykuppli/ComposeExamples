package com.vijaykuppli.android.screen.modifier

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class ModifierExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierExample()
        }
    }
}

@Composable
fun ModifierExample() {
    Column(
        modifier = Modifier
            .background(Color.Yellow)
//            .wrapContentWidth() // works like wrapContent
//            .wrapContentHeight() // works like wrapContent
            .fillMaxSize()
            .padding(top = 50.dp)
            .border(5.dp, Color.Red),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        Text(
            text = "Hello Namasthe",
            modifier = Modifier
//                .offset(50.dp, 20.dp), // this works as margin but there is a different this won't disturb other views.
                .clickable {
                    Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                }
        )
        Spacer(modifier = Modifier.height(30.dp)) // this gives 30 dp space between two texts.
        Text(
            text = "Vanakkam"
        )
    }
}