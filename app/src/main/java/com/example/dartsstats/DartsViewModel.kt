package com.example.dartsstats

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DartsViewModel() : ViewModel() {
    private val _state = MutableStateFlow(DartsState())
    val state: StateFlow<DartsState> = _state.asStateFlow()



}

