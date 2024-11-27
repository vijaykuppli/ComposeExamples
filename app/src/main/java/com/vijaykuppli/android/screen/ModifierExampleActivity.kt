package com.vijaykuppli.android.screen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vijaykuppli.android.screen.ui.theme.ComposeExamplesTheme

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