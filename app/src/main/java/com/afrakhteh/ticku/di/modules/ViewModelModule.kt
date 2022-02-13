package com.afrakhteh.ticku.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afrakhteh.ticku.di.VmKey
import com.afrakhteh.ticku.viewModel.HomeViewModel
import com.afrakhteh.ticku.viewModel.VMFactory
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
}