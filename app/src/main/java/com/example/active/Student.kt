package com.example.active

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "student_info")
data class Student (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    val id:Int,


    @ColumnInfo(name = "subject_name")
    var email : String?
    )