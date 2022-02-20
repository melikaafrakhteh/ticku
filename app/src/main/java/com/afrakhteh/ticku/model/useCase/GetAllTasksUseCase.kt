package com.afrakhteh.ticku.model.useCase

import android.util.Log
import com.afrakhteh.ticku.di.scopes.UseCaseScope
import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.model.repository.list.ListTasksRepository
import com.afrakhteh.ticku.util.DomainDataMapper
import com.afrakhteh.ticku.util.flattenToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@UseCaseScope
class GetAllTasksUseCase @Inject constructor(
    private val listTasksRepository: ListTasksRepository,
    private val mapper: DomainDataMapper<TaskEntity, Tasks>
) {
    operator fun invoke(): Flow<List<TaskEntity>> = flow {
         listTasksRepository.getAllTasks().map { lists ->
           emit(lists.map {
               mapper.convertDataToDomain(it)
           })
             Log.d("usecase", "getAllTask: $lists")
       }
    }
}