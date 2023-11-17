package com.example.active

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface StudentDAO {
    @Insert
    suspend fun insertStudent(student: Student)
}