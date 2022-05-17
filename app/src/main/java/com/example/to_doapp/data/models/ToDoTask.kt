package com.example.to_doapp.data.models

import android.icu.text.CaseMap
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.to_doapp.util.Constants.DATABASE_NAME
import com.example.to_doapp.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
