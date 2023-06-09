package com.example.taskmasterpro_v2.ui.dialog

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.taskmasterpro_v2.R
import com.example.taskmasterpro_v2.databinding.ItemChooseCardBinding
import com.example.taskmasterpro_v2.model.Daily
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ChooseDailyDialogFragment(listener: DailyDialogListener, cards: List<Daily>): BottomSheetDialogFragment() {


    lateinit var binding: ItemChooseCardBinding
    private val _cards = cards
    private var mBottomSheetListener: DailyDialogListener?=null

    init {
        this.mBottomSheetListener = listener
    }



    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            window?.setDimAmount(0.4f) /** Set dim amount here (the dimming factor of the parent fragment) */

            /** IMPORTANT! Here we set transparency to dialog layer */
            setOnShowListener {
                val bottomSheet = findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
                bottomSheet.setBackgroundResource(android.R.color.transparent)

                addCardsToView(bottomSheet) /** add cards to View programmatically */
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = ItemChooseCardBinding.bind(inflater.inflate(R.layout.item_choose_card, container))
        return binding.root

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /** attach listener from parent fragment */
        try {
            mBottomSheetListener = context as DailyDialogListener?
        }
        catch (e: ClassCastException){
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables", "ResourceType")
    private fun addCardsToView(bottomSheet: FrameLayout) {
        val mInflater = requireContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rootView = bottomSheet.getChildAt(0) as ConstraintLayout
        val injectedView = rootView.getChildAt(1) as LinearLayout

        for (i in 1.._cards.size) {

            val rootView = mInflater.inflate(R.layout.item_choosen_card_element, null) as ConstraintLayout

            rootView.setOnClickListener {
                mBottomSheetListener?.chooseDailyClick(_cards[i-1])
            }

            /** Set view */
            val cardTextView = rootView.getChildAt(2) as TextView
            /** Set data */
            cardTextView.text = _cards[i-1].text
            /** Add to View container */
            injectedView.addView(rootView, injectedView.childCount)
        }

        /** +1 item (create new card logic) */
        val rootViewEmpty = mInflater.inflate(R.layout.item_choose_card_empty, null) as ConstraintLayout
        rootViewEmpty.setOnClickListener {
            mBottomSheetListener?.newDailyClick()
        }
        injectedView.addView(rootViewEmpty, injectedView.childCount)

    }

    interface DailyDialogListener {
        fun chooseDailyClick(card: Daily)
        fun newDailyClick()
    }
}