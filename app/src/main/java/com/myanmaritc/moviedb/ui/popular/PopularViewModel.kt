package com.myanmaritc.moviedb.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PopularViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Popular"
    }
    val text: LiveData<String> = _text
}