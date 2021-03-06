package com.rorono.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rorono.composition.R
import com.rorono.composition.databinding.FragmentWelcomBinding
import java.lang.RuntimeException


class WelcomFragment : Fragment() {
    private var _binding: FragmentWelcomBinding? = null
    private val binding: FragmentWelcomBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonUnderstand.setOnClickListener {
          launchChooseLevelFragment()
        }
    }

    private fun launchChooseLevelFragment() {
        findNavController().navigate(R.id.action_welcomFragment_to_chooseLevelFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}