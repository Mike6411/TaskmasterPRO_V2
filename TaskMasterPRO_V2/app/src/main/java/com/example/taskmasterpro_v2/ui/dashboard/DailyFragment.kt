package com.example.taskmasterpro_v2.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskmasterpro_v2.databinding.FragmentDailyBinding
import com.example.taskmasterpro_v2.model.Daily
import com.example.taskmasterpro_v2.ui.dialog.ChooseDailyDialogFragment

class DailyFragment : Fragment(), ChooseDailyDialogFragment.DailyDialogListener {

    private var _binding: FragmentDailyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    /** Dialog */
    lateinit var dialog: ChooseDailyDialogFragment /** BottomSheetDialogFragment for choose card */
    lateinit var listener: ChooseDailyDialogFragment.DailyDialogListener /** Listener for choose card */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = this /** set listener of BottomSheetDialogFragment */
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(DailyViewModel::class.java)

        _binding = FragmentDailyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /** Create and open dialog */
        binding.button.setOnClickListener {
            dialog = ChooseDailyDialogFragment(listener, homeViewModel.dailies)
            dialog.show(this.parentFragmentManager, "tag")
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /** override click to item from dialog */
    override fun chooseDailyClick(card: Daily) {
        binding.textView.text = "You choose  ${card.text}"
        dialog.dismiss()
    }

    /** override click to additional logic */
    override fun newDailyClick() {
        binding.textView.text = "You need to create new card"
        dialog.dismiss()
    }
}