package com.vijaykuppli.android.screen.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class ConstriantLayoutExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutExample()
        }
    }
}

@Composable
fun ConstraintLayoutExample() {
    val constraintSet = ConstraintSet {
        val userName = createRefFor("username")
        val passWord = createRefFor("password")
        val loginButton = createRefFor("login")

        constrain(userName) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)

            width = Dimension.value(200.dp)
            height = Dimension.value(50.dp)
        }
        constrain(passWord) {
            start.linkTo(userName.start)
            top.linkTo(userName.bottom)
            end.linkTo(userName.end)

            width = Dimension.value(200.dp)
            height = Dimension.value(50.dp)
        }

        constrain(loginButton) {
            start.linkTo(passWord.start)
            top.linkTo(passWord.bottom)
            end.linkTo(passWord.end)

            width = Dimension.value(200.dp)
            height = Dimension.value(50.dp)
        }

        createVerticalChain(userName, passWord, loginButton, chainStyle = ChainStyle.Packed)
    }

    ConstraintLayout(constraintSet = constraintSet, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .layoutId("username")
        ) {
            TextField(
                value = "UserName",
                onValueChange = {

                }
            )
        }
        Box(
            modifier = Modifier
                .layoutId("password")
        ) {
            TextField(
                value = "Password",
                onValueChange = {

                }
            )
        }
        Box(
            modifier = Modifier
                .layoutId("login")
        ) {
            Button(
                onClick = {

                }
            ) {
                Text(text = "Login")
            }
        }
    }
}