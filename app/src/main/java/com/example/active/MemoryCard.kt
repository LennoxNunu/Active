package com.example.active

import android.util.Log
import javax.inject.Inject

class MemoryCard @Inject constructor(){
    init {
        Log.i("MTTAG","Memory Card Constructed")
    }

    fun getSpaceAvailability(){
        Log.i("MYTAG","Memory space available")
    }
}