package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.model.repository.main.TaskRepository
import com.afrakhteh.ticku.util.DomainDataMapper
import javax.inject.Inject

@UseCaseScope
class GetOneTaskUseCase @Inject constructor(
    private val repository: TaskRepository,
    private val mapper: DomainDataMapper<TaskEntity, Tasks>
) {
    suspend operator fun invoke (id: Int): TaskEntity {
        return mapper.convertDataToDomain(
            repository.getOneTask(id)
        )
    }
}