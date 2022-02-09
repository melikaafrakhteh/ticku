package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.repository.list.ListTasksRepository
import javax.inject.Inject

@UseCaseScope
class DeleteAllTaskByTypeUseCase
@Inject constructor(
    private val listTasksRepository: ListTasksRepository
) {
    suspend operator fun invoke(type: Int) {
        listTasksRepository.deleteAllTasksByType(type)
    }
}