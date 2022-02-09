package com.afrakhteh.ticku.model.entities

data class TaskEntity(
    val id: Int,
    val task: String?,
    val taskType: Int,
    val date: Long,
    val isDone: Boolean
)
