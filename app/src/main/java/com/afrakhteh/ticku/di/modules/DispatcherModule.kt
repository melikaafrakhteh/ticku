package com.afrakhteh.ticku.di.modules

import com.afrakhteh.ticku.di.qualifier.IoDispatcher
import com.afrakhteh.ticku.di.qualifier.MainDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class DispatcherModule {

    @IoDispatcher
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}