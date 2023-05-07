package com.example.taskmasterpro_v2.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DailyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the dailies Fragment"
    }
    val text: LiveData<String> = _text
}