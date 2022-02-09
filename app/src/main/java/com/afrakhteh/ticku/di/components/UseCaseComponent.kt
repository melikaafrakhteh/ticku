package com.afrakhteh.ticku.di.components

import com.afrakhteh.ticku.di.modules.UseCaseModule
import com.afrakhteh.ticku.di.scopes.UseCaseScope
import dagger.Component

@Component(
    modules = [UseCaseModule::class],
    dependencies = [RepositoryComponent::class]
)
@UseCaseScope
interface UseCaseComponent {

}