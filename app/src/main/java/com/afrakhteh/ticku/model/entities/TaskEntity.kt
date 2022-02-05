package com.afrakhteh.ticku.model.entities

data class TaskEntity(
    val taskName: String?,
    val taskType: Int,
    val date: Long,
    val isDone: Boolean
)
