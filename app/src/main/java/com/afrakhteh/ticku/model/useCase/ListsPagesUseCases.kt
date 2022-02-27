package com.afrakhteh.ticku.model.useCase

import com.afrakhteh.ticku.di.scopes.UseCaseScope

@UseCaseScope
data class ListsPagesUseCases(
    val deleteAllTaskByTypeUseCase: DeleteAllTaskByTypeUseCase,
    val getAllTasksByTypeUseCase: GetAllTasksByTypeUseCase,
    val searchTaskUseCase: SearchTaskUseCase
)
