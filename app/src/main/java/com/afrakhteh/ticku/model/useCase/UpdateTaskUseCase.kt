package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.model.repository.main.TaskRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(
    private val repository: TaskRepository
){
   suspend operator fun invoke(id: Int){
        repository.updateTask(id)
    }
}