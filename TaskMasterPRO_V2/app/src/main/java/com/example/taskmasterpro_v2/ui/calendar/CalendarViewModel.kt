package com.example.taskmasterpro_v2.ui.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalendarViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the Calendar Fragment"
    }
    val text: LiveData<String> = _text
}