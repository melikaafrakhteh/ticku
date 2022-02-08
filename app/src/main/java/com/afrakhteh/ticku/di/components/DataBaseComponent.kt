package com.afrakhteh.ticku.di.components

import com.afrakhteh.ticku.di.modules.DataBaseModule
import com.afrakhteh.ticku.di.scopes.DBScope
import dagger.Component

@Component(
    modules = [DataBaseModule::class],
    dependencies = [ApplicationComponent::class]
)
@DBScope
interface DataBaseComponent {

}