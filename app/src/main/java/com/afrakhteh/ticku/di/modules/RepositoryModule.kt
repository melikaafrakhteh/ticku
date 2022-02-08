package com.afrakhteh.ticku.di.modules

import com.afrakhteh.ticku.di.scopes.RepoScope
import com.afrakhteh.ticku.model.data.database.TaskDao
import com.afrakhteh.ticku.model.repository.list.ListTaskRepositoryImpl
import com.afrakhteh.ticku.model.repository.list.ListTasksRepository
import com.afrakhteh.ticku.model.repository.main.TaskRepository
import com.afrakhteh.ticku.model.repository.main.TaskRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    @RepoScope
    fun providesMainTaskRepository(dao: TaskDao): TaskRepository {
        return TaskRepositoryImpl(dao)
    }

    @Provides
    @RepoScope
    fun providesListTaskRepository(dao: TaskDao): ListTasksRepository{
        return ListTaskRepositoryImpl(dao)
    }
}