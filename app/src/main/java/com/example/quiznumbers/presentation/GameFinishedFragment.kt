package com.example.quiznumbers.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quiznumbers.R
import com.example.quiznumbers.databinding.FragmentGameFinishedBinding

class GameFinishedFragment : Fragment() {

	private val args by navArgs<GameFinishedFragmentArgs>()

	private var _binding: FragmentGameFinishedBinding? = null
	private val binding: FragmentGameFinishedBinding
		get() = _binding ?: throw RuntimeException("FragmentGameFinishedBinding == null")

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
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
		setOnClickListeners()
		bindViews()
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	private fun retryGame() {
		findNavController().popBackStack()
	}

	private fun setOnClickListeners() {
		binding.buttonRetry.setOnClickListener {
			retryGame()
		}
	}

	private fun bindViews() {
		with(binding) {
			emojiResult.setImageResource(getSmileId())
			tvRequiredAnswers.text = String.format(
				getString(R.string.required_score),
				args.gameresult.gameSettings.minCountOfRightAnswers
			)
			tvRequiredPercentage.text = String.format(
				getString(R.string.required_percentage),
				args.gameresult.gameSettings.minPercentOfRightAnswers
			)
			tvScoreAnswers.text = String.format(
				getString(R.string.score_answers),
				args.gameresult.countOfRightAnswers
			)
			tvScorePercentage.text = String.format(
				getString(R.string.score_percentage),
				getPercentageOfRightScore()
			)
		}
	}

	private fun getSmileId(): Int {
		return if (args.gameresult.isWinner) {
			R.drawable.ic_smile
		} else {
			R.drawable.ic_sad
		}
	}

	private fun getPercentageOfRightScore() = with(args.gameresult) {
		if (countOfRightAnswers == 0) {
			0
		} else {
			((countOfRightAnswers / countOFQuestions.toDouble()) * 100).toInt()
		}
	}
}