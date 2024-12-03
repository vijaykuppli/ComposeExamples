package com.vijaykuppli.android.screen.effecthandlers.launchedeffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.vijaykuppli.android.screen.effecthandlers.launchedeffect.viewmodel.LaunchedViewModel
import com.vijaykuppli.android.screen.effecthandlers.launchedeffect.viewmodel.ScreenEvents
import kotlinx.coroutines.delay

class LaunchedEffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchedEventExample(LaunchedViewModel())
        }
    }
}

@Composable
fun LaunchedEventExample(launchedViewModel: LaunchedViewModel) {
    LaunchedEffect(key1 = true) {
        delay(1000L)
        println("Create new coroutine")
        launchedViewModel.countSharedFlow.collect { event ->
            when (event) {
                is ScreenEvents.ShowSnackBar -> {

                }

                is ScreenEvents.ShowToast -> {

                }
            }

        }
    }
}