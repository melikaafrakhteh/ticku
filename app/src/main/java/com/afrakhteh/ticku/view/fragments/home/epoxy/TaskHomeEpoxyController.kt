package com.afrakhteh.ticku.view.fragments.home.epoxy

import com.afrakhteh.ticku.model.entities.TaskEntity
import com.airbnb.epoxy.TypedEpoxyController
import kotlin.contracts.contract

class TaskHomeEpoxyController(
    private var checkAction: (id: Int) -> Unit,
    private var deleteItem: (id: Int) -> Unit
) : TypedEpoxyController<List<TaskEntity>>() {

    override fun buildModels(data: List<TaskEntity>?) {
        data?.forEach { taskEntity ->
            TaskHomeEpoxyModel_().apply {
                id(taskEntity.id)
                title(taskEntity.task)
                isDone(taskEntity.isDone)
                onCheckedAction { this@TaskHomeEpoxyController.checkAction(taskEntity.id)}
                deleteListener { this@TaskHomeEpoxyController.deleteItem(taskEntity.id) }
            }
        }
    }
}