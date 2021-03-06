package com.afrakhteh.ticku.model.repository.main

import android.util.Log
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

    override suspend fun deleteOneTask(id: Int) {
        dao.deleteOneTask(id)
    }

    override suspend fun getOneTask(id: Int): Tasks {
        return dao.getOneTask(id)
    }

    override fun getAllTasksByDay(date: String): Flow<List<Tasks>> {
       return dao.getAllTasksByDay(date)
    }

    override suspend fun updateTask(id: Int) {
        return dao.updateTask(id)
    }
}