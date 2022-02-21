package com.afrakhteh.ticku.model.repository.list

import com.afrakhteh.ticku.model.entities.Tasks
import kotlinx.coroutines.flow.Flow

interface ListTasksRepository {
    suspend fun deleteAllTasksByType(type: Int)
    fun getAllTasksByType(type: Int): Flow<List<Tasks>>
    fun getAllTasks(): Flow<List<Tasks>>
    fun getSearchedTasks(search: String?): Flow<List<Tasks>>
}