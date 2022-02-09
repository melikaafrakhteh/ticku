package com.afrakhteh.ticku.model.repository.main

import com.afrakhteh.ticku.model.entities.Tasks
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insert(task: Tasks)
    fun deleteOneTask(id: Int)
    suspend fun getOneTask(id: Int): Tasks
    fun getAllTasksByDay(date: Long): Flow<List<Tasks>>
}