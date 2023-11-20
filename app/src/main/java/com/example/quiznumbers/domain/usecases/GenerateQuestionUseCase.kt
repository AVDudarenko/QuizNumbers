package com.example.quiznumbers.domain.usecases

import com.example.quiznumbers.domain.entity.Question
import com.example.quiznumbers.domain.repository.GameRepository

class GenerateQuestionUseCase(
	private val repository: GameRepository
) {
	operator fun invoke(maxSumValue: Int): Question {
		return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
	}

	private companion object {
		private const val COUNT_OF_OPTIONS = 6
	}
}