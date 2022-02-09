package com.afrakhteh.ticku.di.components

import com.afrakhteh.ticku.di.modules.MapperModule
import com.afrakhteh.ticku.di.modules.RepositoryModule
import com.afrakhteh.ticku.di.scopes.RepoScope
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.model.repository.list.ListTasksRepository
import com.afrakhteh.ticku.model.repository.main.TaskRepository
import com.afrakhteh.ticku.util.DomainDataMapper
import dagger.Component

@Component(
    modules = [RepositoryModule::class,
        MapperModule::class],
    dependencies = [DataBaseComponent::class]
)
@RepoScope
interface RepositoryComponent {
    fun exposeMapper(): DomainDataMapper<TaskEntity, Tasks>

    fun exposeMainTaskRepository(): TaskRepository
    fun exposeListTaskRepository(): ListTasksRepository
}