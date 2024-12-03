package com.vijaykuppli.android.screen.bottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vijaykuppli.android.R
import com.vijaykuppli.android.screen.bottomnav.ui.theme.BlueViolet2
import com.vijaykuppli.android.screen.bottomnav.ui.theme.ButtonBlue
import com.vijaykuppli.android.screen.bottomnav.ui.theme.DarkerButtonBlue
import com.vijaykuppli.android.screen.bottomnav.ui.theme.DeepBlue
import com.vijaykuppli.android.screen.bottomnav.ui.theme.TextWhite

class BottomNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowHomeView()
        }
    }
}

@Composable
fun ShowHomeView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
    ) {
        Column {
            ShowGreetingSection()
            ShowHorizontalButtons(
                listOf(
                    "Login",
                    "Registration",
                    "Account",
                    "Settings",
                    "Show Movies"
                )
            )
            ShowHeroView()
        }
    }
}

@Composable
fun ShowGreetingSection(name: String = "Vijay Santosh kumar") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning $name",
                style = MaterialTheme.typography.headlineMedium,
                color = TextWhite,
                fontSize = 16.sp
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite,
                fontSize = 16.sp
            )
        }
        Icon(
            painter = painterResource(R.drawable.search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ShowHorizontalButtons(buttonList: List<String>) {
    var selectedButtonNameState by remember {
        mutableIntStateOf(0)
    }
    LazyRow {
        items(count = buttonList.size) {
            /**
             * If we use button directly then check UI how it appears.
             */
            /* Button(modifier = Modifier.padding(start = 15.dp),
                 onClick = {
                 if (selectedButtonNameState == 0) {
                     ButtonBlue
                 } else {
                     DarkerButtonBlue
                 }
             }) {
                 Text(text = buttonList[it])
             }*/


            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        selectedButtonNameState = it
                    }
                    .background(
                        if (selectedButtonNameState == it) {
                            ButtonBlue
                        } else {
                            DarkerButtonBlue
                        }
                    )
                    .padding(15.dp)
            ) {
                Text(
                    text = buttonList[it],
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun ShowHeroView() {
    Box(modifier = Modifier.padding(15.dp)) {
        Image(
            painter = painterResource(R.mipmap.images),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentDescription = "Background image",
            contentScale = ContentScale.FillWidth
        )
        Box {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Daily Thought",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Meditation 3-10 min",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
                Icon(
                    painter = painterResource(R.drawable.baseline_play_circle_24),
                    contentDescription = "Search",
                    tint = BlueViolet2,
                    modifier = Modifier.size(34.dp)
                )
            }
        }
    }
}