package dev.olaore.mamopay_exercise.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dev.olaore.mamopay_exercise.R
import dev.olaore.mamopay_exercise.Util
import dev.olaore.mamopay_exercise.adapters.NumberAdapter
import dev.olaore.mamopay_exercise.databinding.FragmentInputBinding
import dev.olaore.mamopay_exercise.listeners.OnItemClickedListener

class InputFragment : Fragment(), OnItemClickedListener {

    private lateinit var binding: FragmentInputBinding
    private lateinit var numberAdapter: NumberAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInputBinding.inflate(inflater)
        numberAdapter = NumberAdapter(requireContext(), Util.KEYBOARD_VALUES, this)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.keyboardList.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = numberAdapter
        }
    }

    override fun onBackspaceClicked() {
        Toast.makeText(requireContext(), "Backspace Clicked!", Toast.LENGTH_SHORT).show()
    }

    override fun onNumberClicked(value: String) {
        Toast.makeText(requireContext(), "Value $value", Toast.LENGTH_SHORT).show()
    }

}