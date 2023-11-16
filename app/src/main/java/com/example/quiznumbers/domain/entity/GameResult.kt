package com.example.quiznumbers.domain.entity

import java.io.Serializable

data class GameResult(
    val isWinner: Boolean,
    val countOfRightAnswers: Int,
    val countOFQuestions: Int,
    val gameSettings: GameSettings
) : Serializable