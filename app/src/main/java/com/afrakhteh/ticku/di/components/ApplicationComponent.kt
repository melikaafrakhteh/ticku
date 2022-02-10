package com.afrakhteh.ticku.di.components

import android.app.Application
import android.content.Context
import com.afrakhteh.ticku.App
import com.afrakhteh.ticku.di.modules.ApplicationModule
import com.afrakhteh.ticku.di.modules.DispatcherModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Component(
    modules = [
        ApplicationModule::class,
        DispatcherModule::class]
)
@Singleton
interface ApplicationComponent : AndroidInjector<App> {
    fun exposeContext(): Context
    fun exposeIoDispatcher(): CoroutineDispatcher
    fun exposeMainDispatcher(): CoroutineDispatcher

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(app: Application): Builder

        fun build(): ApplicationComponent
    }
}