package com.example.active

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.active.db.StudentDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = StudentDatabase.getInstance(application).studentDAO


        val subjectEditText = findViewById<EditText>(R.id.etSubject)
        val button = findViewById<Button>(R.id.btnSubmit)

        button.setOnClickListener{
            lifecycleScope.launch {
                subjectEditText.text.let{
                    dao.insertStudent(Student(0,it.toString()))
                    subjectEditText.setText("")
                }
            }
        }
    }
}