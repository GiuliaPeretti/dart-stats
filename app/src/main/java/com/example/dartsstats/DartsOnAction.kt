package com.example.dartsstats

import android.content.Context

open class DartsOnAction {
    data class UpdateScore(val bo: String): DartsOnAction()
    data class StartGame(val context: Context) : DartsOnAction()
    data class SelectTopic(val topic: String, val description: String) : DartsOnAction()
}