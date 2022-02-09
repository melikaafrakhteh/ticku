package com.afrakhteh.ticku.model.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afrakhteh.ticku.model.entities.Tasks
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Tasks)

    @Query("DELETE FROM Tasks WHERE taskId = :id")
    fun deleteOneTask(id: Int)

    @Query("DELETE FROM Tasks WHERE taskType = :type")
    suspend fun deleteAllTasksByType(type: Int)

    @Query("SELECT * FROM Tasks WHERE date = :date")
    fun getAllTasksByDay(date: Long): Flow<List<Tasks>>

    @Query("SELECT * FROM Tasks WHERE taskType = :type")
    fun getAllTasksByType(type: Int): Flow<List<Tasks>>

    @Query("SELECT * FROM Tasks WHERE taskId = :id")
    suspend fun getOneTask(id: Int): Tasks

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Tasks>>
}