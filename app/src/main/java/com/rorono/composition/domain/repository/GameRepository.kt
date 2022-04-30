package com.rorono.composition.domain.repository

import com.rorono.composition.domain.entity.GameSettings
import com.rorono.composition.domain.entity.Level
import com.rorono.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}