package com.example.quiznumbers.domain.repository

import com.example.quiznumbers.domain.entity.GameSettings
import com.example.quiznumbers.domain.entity.Level
import com.example.quiznumbers.domain.entity.Question

interface GameRepository {

	fun generateQuestion(
		maxSumValue: Int,
		countOfOptions: Int
	): Question

	fun getGameSetting(level: Level): GameSettings

}