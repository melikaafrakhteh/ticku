package com.afrakhteh.ticku.di.modules

import androidx.lifecycle.ViewModel
import com.afrakhteh.ticku.di.VmKey
import com.afrakhteh.ticku.viewModel.HomeViewModel
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
}