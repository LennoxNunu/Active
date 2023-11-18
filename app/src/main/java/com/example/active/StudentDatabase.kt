package com.example.active.db


import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import com.example.active.Student
import com.example.active.StudentDAO


@Database(entities = [Student::class], version = 4, autoMigrations = [
    AutoMigration(from = 1, to = 2),
    AutoMigration(from = 2, to = 3, spec = StudentDatabase.Migration2To3::class),
    AutoMigration(from = 3, to = 4, spec = StudentDatabase.Migration3To4::class),
])
abstract class StudentDatabase : RoomDatabase() {

    abstract val studentDAO: StudentDAO

    @RenameColumn(
        tableName = "student_info",
        fromColumnName = "student_email",
        toColumnName = "subject_name")
    class Migration2To3 : AutoMigrationSpec

    @DeleteColumn(
        tableName = "student_info",
        columnName = "student_name")
    class Migration3To4 : AutoMigrationSpec
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