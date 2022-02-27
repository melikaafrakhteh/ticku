package com.afrakhteh.ticku.viewModel

import androidx.lifecycle.*
import com.afrakhteh.ticku.di.qualifier.IoDispatcher
import com.afrakhteh.ticku.di.scopes.VmScope
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.useCase.ListsPagesUseCases
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@VmScope
class CategoryViewModel @Inject constructor(
    private val useCases: ListsPagesUseCases
) : ViewModel() {

    private val pListOfData = MutableStateFlow<List<TaskEntity>>(emptyList())
    val listOfData: StateFlow<List<TaskEntity>> get() = pListOfData

    fun getCategoryItem(type: Int) {
        viewModelScope.launch {
            useCases.getAllTasksByTypeUseCase(type).collectLatest {
                pListOfData.value = it
            }
        }
    }

    fun deleteAllCategoryList(type: Int) {
        viewModelScope.launch {
            useCases.deleteAllTaskByTypeUseCase(type)
        }
    }
}