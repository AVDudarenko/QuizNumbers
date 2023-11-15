package com.example.quiznumbers.domain.entity

data class GameResult(
	val isWinner: Boolean,
	val countOfRightAnswers: Int,
	val countOFQuestions: Int,
	val gameSettings: GameSettings
)