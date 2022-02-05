package com.afrakhteh.ticku.model.entities

data class TaskEntity(
    val noteName: String?,
    val noteType: Int,
    val date: Long,
    val isDone: Boolean
)
