package com.example.taskmasterpro_v2.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the ToDo Fragment"
    }
    val text: LiveData<String> = _text
}