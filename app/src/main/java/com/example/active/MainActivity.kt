package com.example.active

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.active.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.submitButton.setOnClickListener {
            displayGreeting()
        }
    }

    private  fun displayGreeting(){
       binding.apply {
           greetingTextView.text = "Hello "+nameEditText.text
       }
    }

}