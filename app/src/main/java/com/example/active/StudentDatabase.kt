package com.example.active.db


import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.active.Student
import com.example.active.StudentDAO


@Database(entities = [Student::class], version = 2, autoMigrations = [AutoMigration(from = 1, to = 2)])
abstract class StudentDatabase : RoomDatabase() {

    abstract val studentDAO: StudentDAO

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null
        fun getInstance(context: Context): StudentDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            StudentDatabase::class.java,
                            "student_data_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}