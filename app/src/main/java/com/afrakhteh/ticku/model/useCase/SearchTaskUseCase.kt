package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.model.repository.list.ListTasksRepository
import com.afrakhteh.ticku.util.DomainDataMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchTaskUseCase @Inject constructor(
    private val repository: ListTasksRepository,
    private val mapper: DomainDataMapper<TaskEntity, Tasks>,
    private val io: CoroutineDispatcher

) {
    operator fun invoke(text: String?): Flow<List<TaskEntity>> {
        return repository.getSearchedTasks(text).map { tasks ->
            tasks.map {
                mapper.convertDataToDomain(it)
            }
        }.flowOn(io)
    }
}