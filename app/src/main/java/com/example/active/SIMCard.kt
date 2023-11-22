package com.example.active

import android.util.Log

class SIMCard( ) {
    public lateinit var serviceProvider: ServiceProvider
    init {
        Log.i("MYTAG","SIM Card Constructed")
    }

    fun setServiceProvider(serviceProvider: ServiceProvider){
        this.serviceProvider = serviceProvider
    }

    fun getConnection(){
        serviceProvider.getServiceProvider()
    }
}