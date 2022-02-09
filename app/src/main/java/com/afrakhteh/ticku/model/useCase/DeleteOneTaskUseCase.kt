package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.repository.main.TaskRepository
import javax.inject.Inject

@UseCaseScope
class DeleteOneTaskUseCase @Inject constructor(
    private val repository: TaskRepository
 ) {
    operator fun invoke (id: Int) {
        repository.deleteOneTask(id)
    }
}