package com.vijaykuppli.android.screen.textview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vijaykuppli.android.R

class TextStyleExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextStyleExample()
        }
    }
}

@Composable
fun TextStyleExample() {
    val fontSizes = FontFamily(
        Font(R.font.roboto_black, FontWeight.Bold),
        Font(R.font.roboto_light, FontWeight.Bold)
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                ), {
                    append("Vijay")
                }
            )
            append("santosh")
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                ), {
                    append("Kumar")
                }
            )
        },
        fontSize = 20.sp,
        fontStyle = FontStyle.Normal,
        fontFamily = fontSizes,
        color = Color.Blue,
        fontWeight = FontWeight.Thin,
        textAlign = TextAlign.Center
    )
}