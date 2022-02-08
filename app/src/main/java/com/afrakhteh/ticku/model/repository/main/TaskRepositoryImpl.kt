package com.afrakhteh.ticku.model.repository.main

import com.afrakhteh.ticku.di.scopes.RepoScope
import com.afrakhteh.ticku.model.data.database.TaskDao
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.model.repository.main.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@RepoScope
class TaskRepositoryImpl @Inject constructor(
    private val dao: TaskDao
) : TaskRepository {

    override suspend fun insert(task: Tasks) {
        dao.insert(task)
    }

    override fun deleteOneTask(id: Int) {
        dao.deleteOneTask(id)
    }

    override fun getAllTasksByDay(date: Long): Flow<List<Tasks>> = dao.getAllTasksByDay(date)
}