package com.example.taskmasterpro_v2.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskmasterpro_v2.model.Daily

class DailyViewModel : ViewModel() {

    val dailies = getCardsMockup()

    /** LOCAL MOCKUP */
    private fun getCardsMockup(): List<Daily> {
        val cards: MutableList<Daily> = mutableListOf()
        cards.add(Daily(id = "1", text = "••••  5282"))
        cards.add(Daily(id = "2", text = "••••  4450"))
        cards.add(Daily(id = "3", text = "••••  3498"))
        cards.add(Daily(id = "4", text = "••••  0244"))
        return cards
    }
}