package com.example.kotlinlearnapp.TodoListActivityResources

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val deadline: Date?,
    val updatedDate: Date = Date()
)