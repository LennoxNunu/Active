package com.example.fragmentwithviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fragmentwithviewmodel.databinding.ActivityMainBinding
import com.example.fragmentwithviewmodel.ui.main.MainFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

//        lifecycleScope.launch {
//            delay(2000)
//            binding.progressBar.visibility = View.VISIBLE
//            delay(5000)
//            binding.progressBar.visibility = View.GONE
//        }

        lifecycleScope.launch(Dispatchers.IO) {
            Log.i("MyTag"," thread is : ${Thread.currentThread().name}")
        }
    }
}