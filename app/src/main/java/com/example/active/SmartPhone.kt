package com.example.active

import android.util.Log

class SmartPhone(val battery: Battery,val simCard: SIMCard,val memoryCard: MemoryCard) {
    init {
        Log.i("MYTAG","SmartPhone Constructed")
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailability()
    }

    fun makeACallWithRecording(){
        Log.i("MYTAG","Calling .....")
    }
}