package com.vijaykuppli.android.screen.effecthandlers.launchedeffect.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LaunchedViewModel : ViewModel() {
    private val _countSharedFlow = MutableSharedFlow<ScreenEvents>()
    val countSharedFlow = _countSharedFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            _countSharedFlow.emit(ScreenEvents.ShowSnackBar("Welcome Vijay"))

        }
    }
}

sealed class ScreenEvents {
    data class ShowSnackBar(val message: String) : ScreenEvents()
    data class ShowToast(val toastMessage: String) : ScreenEvents()
}