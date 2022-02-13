package com.afrakhteh.ticku.di.builders

import com.afrakhteh.ticku.di.components.DaggerViewModelComponent
import com.afrakhteh.ticku.di.components.ViewModelComponent

object ViewModelComponentBuilder : ComponentBuilder<ViewModelComponent>() {
    override fun provideComponent(): ViewModelComponent {
        return DaggerViewModelComponent.builder()
            .useCaseComponent(UseCaseComponentBuilder.getInstance())
            .applicationComponent(ApplicationComponentBuilder.getInstance())
            .build()
    }
}