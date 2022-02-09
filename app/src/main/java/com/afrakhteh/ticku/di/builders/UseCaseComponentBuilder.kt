package com.afrakhteh.ticku.di.builders

import com.afrakhteh.ticku.di.components.DaggerUseCaseComponent
import com.afrakhteh.ticku.di.components.UseCaseComponent

object UseCaseComponentBuilder : ComponentBuilder<UseCaseComponent>() {
    override fun provideComponent(): UseCaseComponent {
        return DaggerUseCaseComponent.builder()
            .repositoryComponent(RepositoryComponentBuilder.getInstance())
            .build()
    }
}