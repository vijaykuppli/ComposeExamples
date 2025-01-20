package com.vijaykuppli.android.effecthandlers.rememberupdate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdateEffectHandler(
    onTimeOut: () -> Unit
) {

    LaunchedEffect(key1 = true) {
        delay(3000L)
        print("Executed")
    }

    /**
     * If we use above code then it only executes for 1 time as we used TRUE.
     * It won't start again even if we call and pass new TimeOut value.
     *
     * So to remeber the updated value and call the function again then below rememberUpdate we hae to use
     *
     */
    val rememberOnTimeOut by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(3000L)
        rememberOnTimeOut()
        print("Executed")
    }
}