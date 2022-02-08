package com.afrakhteh.ticku.di.builders

import com.afrakhteh.ticku.di.components.DaggerRepositoryComponent
import com.afrakhteh.ticku.di.components.RepositoryComponent

object RepositoryComponentBuilder: ComponentBuilder<RepositoryComponent>() {
    override fun provideComponent(): RepositoryComponent {
       return DaggerRepositoryComponent.builder()
           .dataBaseComponent(DataBaseComponentBuilder.getInstance())
           .build()
    }
}