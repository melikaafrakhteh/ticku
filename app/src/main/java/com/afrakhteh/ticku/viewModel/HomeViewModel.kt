package com.afrakhteh.ticku.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.afrakhteh.ticku.di.qualifier.IoDispatcher
import com.afrakhteh.ticku.di.scopes.VmScope
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.useCase.ListsPagesUseCases
import com.afrakhteh.ticku.model.useCase.MainPageUseCases
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import kotlin.math.log

@VmScope
class HomeViewModel @Inject constructor(
    private val mainPageUseCases: MainPageUseCases,
    private val listsPagesUseCases: ListsPagesUseCases,
   @IoDispatcher private val io: CoroutineDispatcher
) : ViewModel() {

    private val pListOfTasks = listsPagesUseCases.getAllTasksUseCase().asLiveData(viewModelScope.coroutineContext)
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

    fun getAllTask(date: String) {
      val data =  listsPagesUseCases.getAllTasksUseCase().asLiveData()
        Log.d("vm", "getAllTask: ${data.value}")

        //pListOfTasks.postValue(data.value ?: emptyList())
    /* val data =  mainPageUseCases.getAllTasksByDayUseCase(date).asLiveData().value
            Log.d("vm", "getAllTask: $data")
            pListOfTasks.postValue(data ?: emptyList())*/
    }

    override fun onCleared() {
        addJob?.cancel()
        super.onCleared()
    }
}
