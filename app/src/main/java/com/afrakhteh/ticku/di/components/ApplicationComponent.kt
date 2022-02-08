package com.afrakhteh.ticku.di.components

import android.app.Application
import android.content.Context
import com.afrakhteh.ticku.App
import com.afrakhteh.ticku.di.modules.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [ApplicationModule::class]
)
@Singleton
interface ApplicationComponent: AndroidInjector<App> {
 //   fun exposeContext(): Context

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(app: Application): Builder

        fun build(): ApplicationComponent
    }
}