package com.afrakhteh.ticku.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afrakhteh.ticku.di.scopes.VmScope
import javax.inject.Inject
import javax.inject.Provider

@VmScope
@Suppress("UNCHECKED_CAST")
class VMFactory @Inject constructor(
    private val viewModelProviders: Map<@JvmSuppressWildcards Class<out ViewModel>,
            @JvmSuppressWildcards Provider<ViewModel>>
): ViewModelProvider.AndroidViewModelFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = requireNotNull(viewModelProviders[modelClass]) {
            "${modelClass.name} isn't registered in your dagger graph!"
        }
        return provider.get() as T
    }
}