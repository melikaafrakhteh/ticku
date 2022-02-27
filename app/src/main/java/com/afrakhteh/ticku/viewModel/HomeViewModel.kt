package com.afrakhteh.ticku.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afrakhteh.ticku.di.qualifier.IoDispatcher
import com.afrakhteh.ticku.di.scopes.VmScope
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.useCase.MainPageUseCases
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@VmScope
class HomeViewModel @Inject constructor(
    private val mainPageUseCases: MainPageUseCases,
    @IoDispatcher private val io: CoroutineDispatcher
) : ViewModel() {

    private val pListOfTasks = MutableStateFlow<List<TaskEntity>>(emptyList())
    val listOfTasks: StateFlow<List<TaskEntity>> = pListOfTasks

    private var job: Job? = null

    fun addNewTask(taskEntity: TaskEntity) {
        job = CoroutineScope(io).launch {
            mainPageUseCases.addNewTaskUseCase(taskEntity)
        }
    }

    fun removeTask(id: Int) {
        job = CoroutineScope(io).launch {
            mainPageUseCases.deleteOneTaskUseCase(id)
        }
    }

    fun updateTask(id: Int) {
        job = CoroutineScope(io).launch {
            mainPageUseCases.updateTaskUseCase(id)
        }
    }

    fun getAllTask(date: String) {
        viewModelScope.launch {
            mainPageUseCases.getAllTasksByDayUseCase(date).collectLatest {
                Log.d("vm", "$it")
                pListOfTasks.value = it
            }
        }
    }

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }
}
