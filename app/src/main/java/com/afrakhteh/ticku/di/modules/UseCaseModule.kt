package com.afrakhteh.ticku.di.modules

import com.afrakhteh.ticku.di.qualifier.IoDispatcher
import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.model.repository.list.ListTasksRepository
import com.afrakhteh.ticku.model.repository.main.TaskRepository
import com.afrakhteh.ticku.model.useCase.*
import com.afrakhteh.ticku.util.DomainDataMapper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
class UseCaseModule {

    @Provides
    @UseCaseScope
    fun providesMainUseCase(
        repository: TaskRepository,
        mapper: DomainDataMapper<TaskEntity, Tasks>
    ): MainPageUseCases {
        return MainPageUseCases(
            addNewTaskUseCase = AddNewTaskUseCase(mapper, repository),
            deleteOneTaskUseCase = DeleteOneTaskUseCase(repository),
            getAllTasksByDayUseCase = GetAllTasksByDayUseCase(repository, mapper),
            getOneTaskUseCase = GetOneTaskUseCase(repository, mapper)
        )
    }

    @Provides
    @UseCaseScope
    fun providesListsUseCases(
        repository: ListTasksRepository,
        mapper: DomainDataMapper<TaskEntity, Tasks>,
        @IoDispatcher io: CoroutineDispatcher
    ): ListsPagesUseCases {
        return ListsPagesUseCases(
            deleteAllTaskByTypeUseCase = DeleteAllTaskByTypeUseCase(repository),
            getAllTasksByTypeUseCase = GetAllTasksByTypeUseCase(repository, mapper),
            searchTaskUseCase = SearchTaskUseCase(repository, mapper, io)
        )
    }
}