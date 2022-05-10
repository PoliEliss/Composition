package com.rorono.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.rorono.composition.R
import com.rorono.composition.databinding.FragmentGameFinishedBinding
import com.rorono.composition.domain.entity.GameResult
import java.lang.RuntimeException


class GameFinishedFragment : Fragment() {
    private lateinit var gameResult: GameResult
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("GameFinishedFragment == null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
        bindView()

    }

    private fun bindView() {
        val minCountRightAnswers = gameResult.gameSettings.minCountOfRightAnswers
        (getString(R.string.required_scope) + minCountRightAnswers).also {
            binding.tvRequiredAnswer.text = it
        }

        val correctNumberOfAnswer = gameResult.countOfRightAnswers
        (getString(R.string.scope_answer) + correctNumberOfAnswer).also {
            binding.tvScopeAnswers.text = it
        }

        val minPercentOfRightAnswer = gameResult.gameSettings.minPercentOfRightAnswers.toString()
        (getString(R.string.required_percentage) + minPercentOfRightAnswer).also {
            binding.tvRequiredPercentage.text = it
        }

    }

    private fun setupClickListener() {


        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun parseArgs() {
        requireArguments().getParcelable<GameResult>(KEY_GAME_RESULT)?.let {
            gameResult = it
        }
    }


    private fun retryGame() {
        findNavController().popBackStack()
      //  requireActivity().supportFragmentManager.popBackStack(
          //  GameFragment.NAME,
          //  FragmentManager.POP_BACK_STACK_INCLUSIVE
       // )
    }

    companion object {
         const val KEY_GAME_RESULT = "gameResult"
        fun newInstance(gameResult: GameResult): GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT, gameResult)
                }
            }

        }
    }
}