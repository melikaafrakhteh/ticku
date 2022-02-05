package com.afrakhteh.ticku.model.entities

data class NoteEntity(
    val noteName: String?,
    val noteType: Int,
    val date: String,
    val isDone: Boolean
)
