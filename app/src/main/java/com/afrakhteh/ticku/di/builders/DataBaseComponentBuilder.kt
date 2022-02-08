package com.afrakhteh.ticku.di.builders

import com.afrakhteh.ticku.di.components.DaggerDataBaseComponent
import com.afrakhteh.ticku.di.components.DataBaseComponent

object DataBaseComponentBuilder : ComponentBuilder<DataBaseComponent>() {
    override fun provideComponent(): DataBaseComponent {
        return DaggerDataBaseComponent.builder()
            .applicationComponent(ApplicationComponentBuilder.getInstance())
            .build()
    }

}