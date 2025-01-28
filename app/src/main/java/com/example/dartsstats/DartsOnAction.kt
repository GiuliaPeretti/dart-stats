package com.example.dartsstats


open class DartsOnAction {
    data class UpdateScore(val points: List<Int>, val firstPlayer: Boolean): DartsOnAction()
    data class StartGame(val name1: String, val name2: String, val sets: String, val legs: String): DartsOnAction()
    object Clear: DartsOnAction()
}