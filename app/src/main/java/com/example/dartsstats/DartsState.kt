package com.example.dartsstats

data class DartsState(
    var points: List<Int> = listOf(501,501),
    var sets: List<Int> = listOf(0,0),
    var legs: List<Int> = listOf(0,0),
    var setGoal: Int = 0,
)
