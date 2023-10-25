package com.example.active

import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel() {
    private var count = 0

    init {
        count = startingTotal
    }

    fun getCurrentCount():Int{
        return count
    }

    fun getUpdatedCount():Int{
        return ++count
    }
}