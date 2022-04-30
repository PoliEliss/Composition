package com.rorono.composition.domain.usecases

import com.rorono.composition.domain.entity.GameSettings
import com.rorono.composition.domain.entity.Level
import com.rorono.composition.domain.repository.GameRepository

class GetGameSettingUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level): GameSettings {
      return  repository.getGameSettings(level)
    }
}