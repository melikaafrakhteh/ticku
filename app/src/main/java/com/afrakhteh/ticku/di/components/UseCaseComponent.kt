package com.afrakhteh.ticku.di.components

import com.afrakhteh.ticku.di.modules.DispatcherModule
import com.afrakhteh.ticku.di.modules.UseCaseModule
import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.useCase.ListsPagesUseCases
import com.afrakhteh.ticku.model.useCase.MainPageUseCases
import dagger.Component

@Component(
    modules = [UseCaseModule::class, DispatcherModule::class],
    dependencies = [RepositoryComponent::class]
)
@UseCaseScope
interface UseCaseComponent {

    fun exposeMainUSeCase(): MainPageUseCases
    fun exposeListUSeCase(): ListsPagesUseCases
}