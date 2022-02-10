package com.afrakhteh.ticku.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.afrakhteh.ticku.di.qualifier.IoDispatcher
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.useCase.MainPageUseCases
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val mainPageUseCases: MainPageUseCases,
   @IoDispatcher private val io: CoroutineDispatcher
) : ViewModel() {

    private val pListOfTasks = MutableLiveData<List<TaskEntity>>()
    val listOfTasks: LiveData<List<TaskEntity>> = pListOfTasks

    private var addJob: Job? = null

    fun addNewTask(taskEntity: TaskEntity) {
        addJob = CoroutineScope(io).launch {
            mainPageUseCases.addNewTaskUseCase(taskEntity)
        }
    }

    fun removeTask(id: Int){
        mainPageUseCases.deleteOneTaskUseCase(id)
    }

    fun getAllTask(date: Long) {
        mainPageUseCases.getAllTasksByDayUseCase(date).asLiveData(io).let { list ->
            pListOfTasks.postValue(list.value)
        }
    }

    override fun onCleared() {
        addJob?.cancel()
        super.onCleared()
    }
}
