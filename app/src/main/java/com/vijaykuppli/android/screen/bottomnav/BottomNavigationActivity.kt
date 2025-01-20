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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vijaykuppli.android.R
import com.vijaykuppli.android.screen.bottomnav.models.BottomNavMenu
import com.vijaykuppli.android.screen.bottomnav.ui.theme.AquaBlue
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
            CurvedFeatureBox(
                listOf(
                    FeatureList("Vijay", R.drawable.search),
                    FeatureList("Pavani", R.drawable.search),
                    FeatureList("Jayansh", R.drawable.search),
                    FeatureList("Krishna", R.drawable.search)
                )
            )
        }
        BottomNavMenuItems(
            menuItems = listOf(
                BottomNavMenu("Watch", R.drawable.search),
                BottomNavMenu("Shop", R.drawable.search),
                BottomNavMenu("Visit", R.drawable.search),
                BottomNavMenu("Search", R.drawable.search)
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
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
    /**
     * remeber keyword saves the UI state but it doesn't handle screenorientation or app kills or
     * change the theeme. So, we can use remeberSaveable to do that.
     */
    var selectedButtonNameState by rememberSaveable {
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

@Composable
fun CurvedFeatureBox(featureList: List<FeatureList>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Text(
            text = "Features",
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(count = featureList.size) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Yellow)
                ) {
                    Image(
                        painter = painterResource(featureList[1].image),
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(10.dp)),
                        contentDescription = "Background image",
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = "Vijay",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black,
                        modifier = Modifier.padding(10.dp),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavMenuItems(
    menuItems: List<BottomNavMenu>,
    modifier: Modifier = Modifier,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableIntStateOf(initialSelectedItemIndex)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(DeepBlue)
    ) {
        menuItems.forEachIndexed { index, item ->
            BottomMenuItem(
                menuItem = item,
                isSelected = selectedItemIndex == initialSelectedItemIndex
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    menuItem: BottomNavMenu,
    isSelected: Boolean,
    activeHighLightColor: Color = ButtonBlue,
    activeHighLightTextColor: Color = Color.White,
    inActiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighLightColor else Color.Transparent)
        ) {
            Icon(
                painter = painterResource(menuItem.icon),
                contentDescription = "ContentDescritpion",
                tint = if (isSelected) activeHighLightColor else inActiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = menuItem.title,
            style = TextStyle(color = if (isSelected) activeHighLightTextColor else inActiveTextColor)
        )
    }
}