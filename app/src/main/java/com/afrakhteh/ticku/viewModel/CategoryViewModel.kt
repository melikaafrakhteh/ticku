package com.afrakhteh.ticku.viewModel

import androidx.lifecycle.*
import com.afrakhteh.ticku.di.qualifier.IoDispatcher
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.useCase.ListsPagesUseCases
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val useCases: ListsPagesUseCases,
    @IoDispatcher private val io: CoroutineDispatcher
) : ViewModel() {

    private val pListOfData = MutableLiveData<List<TaskEntity>>()
    val listOfData: LiveData<List<TaskEntity>> get() = pListOfData

    fun getCategoryItem(type: Int) {
        useCases.getAllTasksByTypeUseCase(type).asLiveData(io).value?.let {
            pListOfData.postValue(it)
        }
    }

    fun deleteAllCategoryList(type: Int) {
        viewModelScope.launch {
            useCases.deleteAllTaskByTypeUseCase(type)
        }
    }
}