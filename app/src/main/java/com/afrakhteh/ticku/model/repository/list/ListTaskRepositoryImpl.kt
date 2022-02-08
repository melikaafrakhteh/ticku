package com.afrakhteh.ticku.model.repository.list

import com.afrakhteh.ticku.di.scopes.RepoScope
import com.afrakhteh.ticku.model.data.database.TaskDao
import com.afrakhteh.ticku.model.entities.Tasks
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@RepoScope
class ListTaskRepositoryImpl @Inject constructor(
    private val dao: TaskDao
) : ListTasksRepository {

    override suspend fun deleteAllTasksByType(type: Int) {
        dao.deleteAllTasksByType(type)
    }

    override fun getAllTasksByType(type: Int): Flow<List<Tasks>> = dao.getAllTasksByType(type)

    override fun getAllTasks(): Flow<List<Tasks>> = dao.getAllTasks()
}