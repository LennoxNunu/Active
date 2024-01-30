package com.example.active

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel(startingTotal : Int) : ViewModel() {


    private val _flowTotal = MutableStateFlow<Int>(0)
    val flowTotal : StateFlow<Int> = _flowTotal
    //get() = _flowTotal



    init {

        _flowTotal.value = startingTotal
    }

    fun setTotal(input:Int){

        _flowTotal.value = (_flowTotal.value).plus(input)
    }
}