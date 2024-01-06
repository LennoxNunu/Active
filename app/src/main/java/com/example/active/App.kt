package com.example.active

import android.app.Application

class App: Application() {
    lateinit var dataComponent: DataComponent

    override fun onCreate() {
        super.onCreate()
        dataComponent = DaggerDataComponent.builder().build()

    }

}