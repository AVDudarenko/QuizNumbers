package com.example.quiznumbers.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class GameResult(
    val isWinner: Boolean,
    val countOfRightAnswers: Int,
    val countOFQuestions: Int,
    val gameSettings: GameSettings
) : Parcelable