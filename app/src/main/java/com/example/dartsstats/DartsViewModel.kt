package com.example.dartsstats

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow





class DartsViewModel : ViewModel() {
    private val _state = MutableStateFlow(DartsState())
    val state: StateFlow<DartsState> = _state.asStateFlow()

    fun onAction(action: DartsOnAction) {
        when (action) {
            is DartsOnAction.UpdateScore -> update(points = action.points, firstPlayer = action.firstPlayer)
            is DartsOnAction.StartGame ->start(action.name1, action.name2, action.sets,action.legs)
            is DartsOnAction.Clear -> clear()
        }
    }
//cambia nome
    private fun update(points:List<Int>, firstPlayer:Boolean){
        _state.value.game.updateScore(points, firstPlayer)


    }

    private fun start(name1: String, name2: String, sets: String, legs: String){
        _state.value.game.start(name1,name2,sets,legs)

    }

    private fun clear(){
        _state.value = _state.value.copy(
            game = Game()
        )
    }

}

