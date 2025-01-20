package com.vijaykuppli.android.effecthandlers.launchedeffect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LaunchedEffectHandlerViewModel : ViewModel() {
    private val _sharedFlowTextChanger = MutableSharedFlow<EmitMessage>()
    val sharedFlowTextChanger = _sharedFlowTextChanger.asSharedFlow()

    init {
        viewModelScope.launch {
            _sharedFlowTextChanger.emit(EmitMessage.ShowMessage("Sample SnackBar"))
        }
    }
}

sealed class EmitMessage {
    data class ShowSnackBar(val message: String) : EmitMessage()
    data class ShowMessage(val message: String) : EmitMessage()
}