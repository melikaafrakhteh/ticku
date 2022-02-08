package com.afrakhteh.ticku.di.builders

abstract class ComponentBuilder<C> {
    private var instance: C? = null
    abstract fun provideComponent(): C

    fun getInstance(): C {
        if (instance == null) {
            instance = provideComponent()
        }
        return requireNotNull(instance)
    }
}