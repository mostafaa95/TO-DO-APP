package com.example.to_doapp.data.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.to_doapp.data.ToDoDao
import dagger.Provides

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}