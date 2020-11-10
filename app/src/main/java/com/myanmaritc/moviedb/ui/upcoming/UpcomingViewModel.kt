package com.myanmaritc.moviedb.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UpcomingViewModel : ViewModel(){

    private val _text = MutableLiveData<String>().apply {
        value = "This is Upcoming"
    }
    val text: LiveData<String> = _text
}