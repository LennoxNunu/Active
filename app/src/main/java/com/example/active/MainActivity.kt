package com.example.active

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.active.db.StudentDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = StudentDatabase.getInstance(application).studentDAO

        val nameEditText = findViewById<EditText>(R.id.etName)
        val emailEditText = findViewById<EditText>(R.id.etEmail)
        val button = findViewById<Button>(R.id.btnSubmit)

        button.setOnClickListener{
            lifecycleScope.launch {
                nameEditText.text.let{
                    dao.insertStudent(Student(0,it.toString(),emailEditText.text.toString()))
                    nameEditText.setText("")
                    emailEditText.setText("")
                }
            }
        }
    }
}