package com.example.taskmasterpro_v2.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskmasterpro_v2.databinding.FragmentDailyBinding

class DailyFragment : Fragment() {

    private var _binding: FragmentDailyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dailyViewModel =
            ViewModelProvider(this).get(DailyViewModel::class.java)

        _binding = FragmentDailyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDaily
        dailyViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}