package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.data.mapper.DomainDataMapperImpl
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.model.repository.main.TaskRepository
import com.afrakhteh.ticku.util.DomainDataMapper
import javax.inject.Inject

@UseCaseScope
class AddNewTaskUseCase @Inject constructor(
    private val mapperImpl: DomainDataMapper<TaskEntity, Tasks>,
    private val repository: TaskRepository
) {
    suspend operator fun invoke (taskEntity: TaskEntity) {
        repository.insert(mapperImpl.convertDomainToData(taskEntity))
    }
}