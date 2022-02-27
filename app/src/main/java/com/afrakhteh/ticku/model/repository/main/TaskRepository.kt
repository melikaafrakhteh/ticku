package com.afrakhteh.ticku.model.repository.main

import com.afrakhteh.ticku.model.entities.Tasks
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insert(task: Tasks)
    suspend fun deleteOneTask(id: Int)
    suspend fun getOneTask(id: Int): Tasks
    fun getAllTasksByDay(date: String): Flow<List<Tasks>>
}