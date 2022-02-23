package com.afrakhteh.ticku.di.components

import com.afrakhteh.ticku.di.modules.ViewModelModule
import com.afrakhteh.ticku.di.scopes.VmScope
import com.afrakhteh.ticku.view.fragments.category.CategoryFragment
import com.afrakhteh.ticku.view.fragments.home.HomeFragment
import com.afrakhteh.ticku.view.fragments.search.SearchFragment
import dagger.Component

@Component(
    modules = [ViewModelModule::class],
    dependencies = [UseCaseComponent::class,
                    ApplicationComponent::class]
)
@VmScope
interface ViewModelComponent {
    fun inject(homeFragment: HomeFragment)
    fun inject(searchFragment: SearchFragment)
    fun inject(categoryFragment: CategoryFragment)
}