package com.compose.android.screen.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationCompose() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenNames.HomeActivity.route) {
        composable(route = ScreenNames.HomeActivity.route) {
            HomeScreen(navController)
        }
        /**
         * If you want to handle null case then you have to use "/". If you want to make it optional
         * like even if you not enter the value it shouldn't crash or execute then use "?" like "?name={name}"
         */
        composable(route = ScreenNames.DetailActivity.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Vijay Santosh"
                    nullable = true
                }
            )
        ) { entry ->
            DetailsScreen(name = entry.arguments?.getString("name"))
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(40.dp)
            .fillMaxSize()
    ) {
        TextField(value = text, onValueChange = {
            text = it
        }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                navController.navigate(route = ScreenNames.DetailActivity.withArgs(text))
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To DetailScreen", color = Color.White)
        }
    }
}


@Composable
fun DetailsScreen(name: String?) {
    Text(text = name.orEmpty(), modifier = Modifier.fillMaxSize())
}