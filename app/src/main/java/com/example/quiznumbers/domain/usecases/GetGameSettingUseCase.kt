package com.example.quiznumbers.domain.usecases

import com.example.quiznumbers.domain.entity.GameSettings
import com.example.quiznumbers.domain.entity.Level
import com.example.quiznumbers.domain.repository.GameRepository

class GetGameSettingUseCase(
	private val repository: GameRepository
) {

	operator fun invoke(gameLevel: Level): GameSettings {
		return repository.getGameSetting(gameLevel)
	}
}