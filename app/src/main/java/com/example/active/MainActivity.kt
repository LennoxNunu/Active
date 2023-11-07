package com.example.active

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var btnDownLoadUserData : Button
    private lateinit var btnCount : Button
    private lateinit var tvCount : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDownLoadUserData = findViewById(R.id.btnDownloadUserData)
        btnCount = findViewById(R.id.btnCount)
        tvCount = findViewById(R.id.tvCount)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }

        btnDownLoadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }

    }

    private fun downloadUserData() {
        for(i in 1..200000){
            Log.i("My Tag","Downloading user $i in ${Thread.currentThread().name}")

        }
    }
}