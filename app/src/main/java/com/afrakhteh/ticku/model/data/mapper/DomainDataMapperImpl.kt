package com.afrakhteh.ticku.model.data.mapper

import com.afrakhteh.ticku.model.entities.TaskEntity
import com.afrakhteh.ticku.model.entities.Tasks
import com.afrakhteh.ticku.util.DomainDataMapper
import javax.inject.Inject

class DomainDataMapperImpl @Inject constructor(): DomainDataMapper<TaskEntity, Tasks> {

    override fun convertDomainToData(domain: TaskEntity): Tasks {
        return Tasks(
            taskName = domain.task,
            taskType = domain.taskType,
            date = domain.date,
            isDone = domain.isDone
        )
    }

    override fun convertDataToDomain(data: Tasks): TaskEntity {
        return TaskEntity(
            task = data.taskName,
            taskType = data.taskType,
            date = data.date,
            isDone = data.isDone
        )
    }
}