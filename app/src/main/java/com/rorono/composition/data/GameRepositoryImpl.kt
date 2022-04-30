package com.rorono.composition.data

import com.rorono.composition.domain.entity.GameSettings
import com.rorono.composition.domain.entity.Level
import com.rorono.composition.domain.entity.Level.*
import com.rorono.composition.domain.entity.Question
import com.rorono.composition.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min

import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt( // это число которое нужно получить
            MIN_SUM_VALUE,
            maxSumValue + 1
        ) // количество вариантов ответов. От двух до 6 т.к нет смысла генерировать от 0 или от 1. Верхняя граница в диапазон не включается
        val visibleNumber = Random.nextInt(
            MIN_ANSWER_VALUE,
            sum
        ) // максимальное возможное видемое число в левом квадрате. Верхняя граница в диапазон не включается
        //варианты ответов
        val options = HashSet<Int>()
        val rightAnswer =
            sum - visibleNumber // правильный ответ будет равен разности числа, которое должно получиться в результате сложения минус то число, которое видно
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options = options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when(level){
            TEST -> GameSettings(10, //максимальное значение суммы 10
                3, // минимальное количество правильных ответов
                50, // минимальный процент правильных ответов
                8)// время игры 8 секунд)
            EASY -> GameSettings(10, //максимальное значение суммы 10
                3, // минимальное количество правильных ответов
                50, // минимальный процент правильных ответов
                8)// время игры 8 секунд)
            NORMAL -> GameSettings(20, //максимальное значение суммы 10
                20, // минимальное количество правильных ответов
                80, // минимальный процент правильных ответов
                40)// время игры 8 секунд)
            HARD -> GameSettings(30, //максимальное значение суммы 10
                30, // минимальное количество правильных ответов
                90, // минимальный процент правильных ответов
                40)// время игры 8 секунд)
        }
    }
}