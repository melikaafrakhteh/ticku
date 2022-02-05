package com.afrakhteh.ticku.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    var taskId: Int = 0,
    val taskName: String?,
    val taskType: Int,
    val date: Long,
    val isDone: Boolean
)