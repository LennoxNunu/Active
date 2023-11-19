package com.example.active

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text_view = findViewById<TextView>(R.id.text_view)

        val retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            val response = retService.getSortedAlbums(3)

            if (response.isSuccessful) {
                val albumsList = response.body()
                if (!albumsList.isNullOrEmpty()) {
                    albumsList?.let {
                        CoroutineScope(Dispatchers.Main).launch {
                            it.forEach { v ->
                                val result: String = " " + "Album Title : ${v.title}" + "\n" +
                                        " " + "Album id : ${v.id}" + "\n" +
                                        " " + "User id : ${v.userId}" + "\n\n\n"

                                text_view.append(result)
                            }
                        }
                    }
                }
            }
        }
    }
}