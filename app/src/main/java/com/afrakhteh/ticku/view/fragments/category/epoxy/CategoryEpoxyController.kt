package com.afrakhteh.ticku.view.fragments.category.epoxy

import com.afrakhteh.ticku.model.entities.TaskEntity
import com.airbnb.epoxy.TypedEpoxyController

class CategoryEpoxyController() : TypedEpoxyController<List<TaskEntity>>() {

    override fun buildModels(data: List<TaskEntity>?) {
        data?.forEach { task ->
            CategoryEpoxyModel_().apply {
                id(task.id)
                title(task.task)
                date(task.date)
                isDone(task.isDone)
            }.addTo(this)
        }
    }
}