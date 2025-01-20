package com.vijaykuppli.android.effecthandlers.launchedeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember


@Composable
fun LaunchedEffectFunction(launchedEffectHandlerViewModel: LaunchedEffectHandlerViewModel) {

    /**
     * Whenever key1 changes then inside launchedeffect block will cancel and start the compose.
     * That means as per below code when key1 = true then only it Sharedflow collects and call
     * ShowMessage() or ShowSnackBar().
     */
    LaunchedEffect(key1 = true) {
        launchedEffectHandlerViewModel.sharedFlowTextChanger.collect { emitMessage ->
            when (emitMessage) {
                is EmitMessage.ShowMessage -> {

                }

                is EmitMessage.ShowSnackBar -> {

                }
            }
        }
    }
}

@Composable
fun LaunchedEffectCounterExample(counter: Int) {
    /**
     * Here whenever counter value changes it cancel the existing coroutineScope and launch with new value.
     * For suppose before getting new counter value existing/old value is 4 then it cancel and start
     * the animation from again 4 to new value.
     */
    val animateValue = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = counter) {
        animateValue.animateTo(counter.toFloat())
    }
}