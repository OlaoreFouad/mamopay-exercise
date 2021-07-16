package dev.olaore.mamopay_exercise.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.olaore.mamopay_exercise.R
import dev.olaore.mamopay_exercise.Util
import dev.olaore.mamopay_exercise.adapters.NumberAdapter
import dev.olaore.mamopay_exercise.databinding.FragmentInputBinding
import dev.olaore.mamopay_exercise.listeners.OnItemClickedListener
import dev.olaore.mamopay_exercise.viewmodels.InputViewModel

class InputFragment : Fragment(), OnItemClickedListener {

    private lateinit var binding: FragmentInputBinding
    private lateinit var numberAdapter: NumberAdapter
    private lateinit var viewModel: InputViewModel

    private var currentValue = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInputBinding.inflate(inflater)
        numberAdapter = NumberAdapter(requireContext(), Util.KEYBOARD_VALUES, this)
        viewModel = ViewModelProvider(requireActivity()).get(InputViewModel::class.java)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.input.observe(viewLifecycleOwner , Observer {
            Log.d("InputFragment", it)
            binding.value = it
        })
        viewModel.formatCurrency(this.currentValue)

        binding.keyboardList.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = numberAdapter
        }
    }

    override fun onBackspaceClicked() {

        if (currentValue.isBlank()) {
            return
        }

        currentValue = currentValue.dropLast(1)
        binding.endsWithPoint = currentValue.endsWith(".")
        viewModel.formatCurrency(currentValue)
    }

    override fun onNumberClicked(value: String) {
        if (
            (value == "." && currentValue.contains("."))// check if string already has decimal point
            || numberEndsWithTwoNonZeroDigits(binding.value!!) // check if number ends with non-zero digits
        ) {
            return
        }

        currentValue += value
        binding.endsWithPoint = currentValue.endsWith(".")
        viewModel.formatCurrency(currentValue)
    }

    private fun numberEndsWithTwoNonZeroDigits(value: String): Boolean {
        val lastDigits = value.substring(value.lastIndex - 1, value.length)
        return !lastDigits.contains("0")
    }

}