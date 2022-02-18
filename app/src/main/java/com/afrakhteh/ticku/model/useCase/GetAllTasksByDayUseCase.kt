package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.model.repository.main.TaskRepository
import com.afrakhteh.ticku.util.DomainDataMapper
import com.afrakhteh.ticku.util.flattenToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@UseCaseScope
class GetAllTasksByDayUseCase @Inject constructor(
    private val repository: TaskRepository,
    private val mapper: DomainDataMapper<TaskEntity, Tasks>
) {
    operator fun invoke(date: String) = flow<List<TaskEntity>> {
        val data = repository.getAllTasksByDay(date).map { list ->
            list.map {
                mapper.convertDataToDomain(it)
            }
        }
        emit(data.flattenToList())
    }
}