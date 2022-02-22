package com.afrakhteh.ticku.view.fragments.search.epoxy

import com.afrakhteh.ticku.model.entities.TaskEntity
import com.airbnb.epoxy.TypedEpoxyController

class SearchEpoxyController() : TypedEpoxyController<List<TaskEntity>>() {

    override fun buildModels(data: List<TaskEntity>?) {
        data?.forEach { task ->
            SearchEpoxyModel_().apply {
                id(task.id)
                title(task.task)
                date(task.date)
                isDone(task.isDone)
            }
        }
    }
}