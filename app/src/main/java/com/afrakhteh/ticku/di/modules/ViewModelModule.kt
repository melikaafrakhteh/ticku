package com.afrakhteh.ticku.di.modules

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.MapInfo
import com.afrakhteh.ticku.di.VmKey
import com.afrakhteh.ticku.view.fragments.category.CategoryFragment
import com.afrakhteh.ticku.viewModel.*
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap

@Module
 interface ViewModelModule {

     @Binds
     @IntoMap
     @VmKey(HomeViewModel::class)
     fun bindHomeVm(viewModel: HomeViewModel): ViewModel


    @Binds
    fun bindViewModelFactory(factory: VMFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @VmKey(SearchViewModel::class)
    fun bindSearchVm(viewModel: SearchViewModel): ViewModel

    @Binds
    @MapInfo
    @VmKey(CategoryViewModel::class)
    fun bindCategoryVm(viewModel: CategoryViewModel): ViewModel
}