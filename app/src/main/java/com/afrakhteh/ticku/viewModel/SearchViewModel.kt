package com.afrakhteh.ticku.viewModel

import androidx.lifecycle.ViewModel
import com.afrakhteh.ticku.model.useCase.ListsPagesUseCases
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val listsPagesUseCases: ListsPagesUseCases
): ViewModel() {

}