package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.model.repository.list.ListTasksRepository
import com.afrakhteh.ticku.util.DomainDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@UseCaseScope
class GetAllTasksByTypeUseCase @Inject constructor(
    private val listTasksRepository: ListTasksRepository,
    private val mapper: DomainDataMapper<TaskEntity, Tasks>
) {
    operator fun invoke (type: Int): Flow<List<TaskEntity>> {
        return listTasksRepository.getAllTasksByType(type).map {lists ->
            lists.map {
                mapper.convertDataToDomain(it)
            }
        }
    }
}