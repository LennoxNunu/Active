package com.example.active

import android.util.Log
import javax.inject.Inject


//lets assume we don't own this class, 'third party class'
class MemoryCard {
    init {
        Log.i("MTTAG","Memory Card Constructed")
    }

    fun getSpaceAvailability(){
        Log.i("MYTAG","Memory space available")
    }
}