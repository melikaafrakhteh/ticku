package com.afrakhteh.ticku.di.components

import com.afrakhteh.ticku.di.modules.UseCaseModule
import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.useCase.ListsPagesUseCases
import com.afrakhteh.ticku.model.useCase.MainPageUseCases
import dagger.Component

@Component(
    modules = [UseCaseModule::class],
    dependencies = [RepositoryComponent::class,
        ApplicationComponent::class]
)
@UseCaseScope
interface UseCaseComponent {

    fun exposeMainUSeCase(): MainPageUseCases
    fun exposeListUSeCase(): ListsPagesUseCases
}