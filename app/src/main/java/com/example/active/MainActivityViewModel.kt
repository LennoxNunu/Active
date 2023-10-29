package com.example.active

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    val userName = MutableLiveData<String>()

    init {
        userName.value = "Frank"
    }
}