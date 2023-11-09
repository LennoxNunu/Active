package com.example.active

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getUserData()
        mainActivityViewModel.users.observe(this, Observer {
            myUsers ->
            if (myUsers != null) {
                myUsers.forEach {
                    Log.i("Mytag", " name is ${it.name}")
                }
            }
        })
    }
}