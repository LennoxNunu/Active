package com.example.active

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.MyRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    val fruitsList = listOf<Fruit>(
    Fruit("Apple","Tom"),
    Fruit("Banana","Frank"),
    Fruit("Mango","Joe"),
    Fruit("Guava","Joe"),
    Fruit("Lemon","Alex"),
    Fruit("Orange","Alex"),
    Fruit("Pear","Joe")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitsList) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit:Fruit){
        Toast.makeText(
            this@MainActivity,
            "Supplier is : ${fruit.supplier}",
            Toast.LENGTH_LONG
        ).show()
    }
}