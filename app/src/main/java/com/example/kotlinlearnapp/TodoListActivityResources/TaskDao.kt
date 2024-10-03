package com.example.kotlinlearnapp.TodoListActivityResources

import androidx.room.*

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Query("SELECT * FROM tasks ORDER BY name ASC")
    suspend fun getTasksSortedByName(): List<Task>

    @Query("SELECT * FROM tasks ORDER BY deadline ASC")
    suspend fun getTasksSortedByDeadline(): List<Task>

    @Query("SELECT * FROM tasks ORDER BY updatedDate DESC")
    suspend fun getTasksSortedByUpdateDate(): List<Task>

    @Query("DELETE FROM tasks WHERE id = :taskId")
    suspend fun deleteTask(taskId: Int)
}