package com.afrakhteh.ticku.di.builders

import android.app.Application
import com.afrakhteh.ticku.di.components.ApplicationComponent
import com.afrakhteh.ticku.di.components.DaggerApplicationComponent

object ApplicationComponentBuilder : ComponentBuilder<ApplicationComponent>() {

    lateinit var app: Application

    override fun provideComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .bindApplication(app)
            .build()
    }
}