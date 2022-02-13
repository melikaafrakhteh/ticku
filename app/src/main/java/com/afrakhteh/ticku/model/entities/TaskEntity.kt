package com.afrakhteh.ticku.model.entities

data class TaskEntity(
    val task: String?,
    val taskType: Int,
    val date: String,
    val isDone: Boolean
)
