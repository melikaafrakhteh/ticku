package com.afrakhteh.ticku.di.components

import com.afrakhteh.ticku.di.modules.RepositoryModule
import com.afrakhteh.ticku.di.scopes.RepoScope
import dagger.Component

@Component(
    modules = [RepositoryModule::class],
    dependencies = [DataBaseComponent::class]
)
@RepoScope
interface RepositoryComponent {
}