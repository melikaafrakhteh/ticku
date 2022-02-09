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
class GetAllTasksUseCase @Inject constructor(
    private val listTasksRepository: ListTasksRepository,
    private val mapper: DomainDataMapper<TaskEntity, Tasks>
) {
    operator fun invoke(): Flow<List<TaskEntity>> {
       return listTasksRepository.getAllTasks().map { lists ->
           lists.map {
               mapper.convertDataToDomain(it)
           }
       }
    }
}