package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.di.scopes.UseCaseScope

@UseCaseScope
data class MainPageUseCases(
    val addNewTaskUseCase: AddNewTaskUseCase,
    val deleteOneTaskUseCase: DeleteOneTaskUseCase,
    val getAllTasksByDayUseCase: GetAllTasksByDayUseCase,
    val getOneTaskUseCase: GetOneTaskUseCase,
    val updateTaskUseCase: UpdateTaskUseCase
)
